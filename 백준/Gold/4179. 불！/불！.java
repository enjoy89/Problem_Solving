import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int R, C;
	static char[][] map;
	static boolean[][] visited_fire;
	static boolean[][] visited_jh;
	static int[][] fire;
	static int[][] jh;
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited_fire = new boolean[R][C];
		visited_jh = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j].charAt(0);
			}
		}

		fire = new int[R][C];
		jh = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				fire[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<int[]> fire_queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F') {
					visited_fire[i][j] = true;
					fire[i][j] = 1;
					fire_queue.offer(new int[] {i, j});
				}
			}
		}
		fire(fire_queue);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					visited_jh[i][j] = true;
					jh[i][j] = 1;
					possible = bfs(i, j);
				}
			}
		}

		if (!possible) {
			System.out.println("IMPOSSIBLE");
		}

	}

	public static void fire(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
					if (!visited_fire[ny][nx] && map[ny][nx] != '#') {
						visited_fire[ny][nx] = true;
						fire[ny][nx] = fire[cy][cx] + 1;
						queue.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}

	public static boolean bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {y, x});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			// 탈출 여부 확인
			if (cy == 0 || cy == R - 1 || cx == 0 || cx == C - 1) {
				System.out.println(jh[cy][cx]);
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
					// 불보다 먼저 도착한 경우
					if (!visited_jh[ny][nx] && map[ny][nx] == '.' && (jh[cy][cx] + 1 < fire[ny][nx])) {
						visited_jh[ny][nx] = true;
						jh[ny][nx] = jh[cy][cx] + 1;
						queue.offer(new int[] {ny, nx});
					}
				}
			}
		}

		return false;
	}
}
