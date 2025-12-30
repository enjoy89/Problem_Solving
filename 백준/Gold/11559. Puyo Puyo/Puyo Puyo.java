import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char[][] filed;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		filed = new char[12][6];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < 6; j++) {
				filed[i][j] = line[j].charAt(0);
			}
		}

		int answer = 0;

		while (true) {
			boolean anyBoom = false;
			boolean[][] checked = new boolean[12][6];   // 이번 턴에서 BFS 시작 여부
			boolean[][] toRemove = new boolean[12][6];  // 이번 턴에 터질 칸 표시

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					char puyo = filed[i][j];
					if (puyo != '.' && !checked[i][j]) {
						boolean boomOccurred = boom(puyo, i, j, checked, toRemove);
						if (boomOccurred) {
							anyBoom = true;
						}
					}
				}
			}

			if (!anyBoom) {
				break;
			}

			// 표시된 칸을 한 번에 제거
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (toRemove[i][j])
						filed[i][j] = '.';
				}
			}

			fall();
			answer++;    // 연쇄 1회 증가
		}

		System.out.println(answer);
	}

	// 같은 색의 뿌요들이 4개 이상 모였는지 bfs로 찾는다.
	// 모였으면 toRemove에 표시만 한다 (여기서 지우거나 fall() 하지 않음)
	public static boolean boom(char puyo, int y, int x, boolean[][] checked, boolean[][] toRemove) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[12][6];

		queue.offer(new int[] {y, x});
		visited[y][x] = true;
		checked[y][x] = true;

		int count = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6)
					continue;
				if (visited[ny][nx])
					continue;
				if (filed[ny][nx] != puyo)
					continue;

				visited[ny][nx] = true;
				checked[ny][nx] = true;
				queue.offer(new int[] {ny, nx});
				count++;
			}
		}

		if (count >= 4) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j])
						toRemove[i][j] = true;
				}
			}
			return true;
		}

		return false;
	}

	// 연쇄 이후 뿌요가 아래로 떨어진다.
	public static void fall() {
		for (int col = 0; col < 6; col++) {
			int write = 11;

			for (int row = 11; row >= 0; row--) {
				if (filed[row][col] != '.') {
					char puyo = filed[row][col];
					filed[row][col] = '.';
					filed[write][col] = puyo;
					write--;
				}
			}

			for (int row = write; row >= 0; row--) {
				filed[row][col] = '.';
			}
		}
	}
}