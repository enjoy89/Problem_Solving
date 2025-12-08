import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처음부터 모든 토마토가 익어있으면 0 출력 후 종료
		boolean check = false;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					check = true;
				}
			}
		}
		if (!check) {
			System.out.println(0);
			return;
		}

		bfs();

		int answer = -1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 탐색 후 안 익은 토마토가 남아 있으면 -1 출력 후 종료
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				} else {
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		System.out.println(answer - 1);

	}

	public static void bfs() {
		// 익은 토마토를 모두 큐에 넣고 시작
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					queue.offer(new int[] {i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = map[cy][cx] + 1;
						queue.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
}
