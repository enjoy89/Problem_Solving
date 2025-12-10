import java.io.*;
import java.util.*;

/**
 * 1. 방향 정하기
 * 2. 그 방향대로 감시 시뮬레이션
 * 3. 사각지대 개수 세기 + 최소값 갱신
 */
public class Main {

	public static class Cctv {
		int x;
		int y;
		int type; // 1~5
		int direction; // 0~3

		public Cctv(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}
	}

	// 0:상 1:우 하:2 좌:3
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static List<Cctv> cctvList = new ArrayList<>();
	static int N, M;
	static int[][] map;

	// 타입별 가능한 방향의 개수
	static int[] dirCount = {0, 4, 2, 4, 4, 1};
	//1번 4가지, 2번 2가지, 3번 4가지, 4번 4가지, 5번 1가지

	static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				if (num > 0 && num < 6) {
					cctvList.add(new Cctv(i, j, num));
				}
			}
		}
		dfs(0);
		System.out.println(minCount);
	}

	public static void dfs(int idx) {
		// 모든 cctv에 대해 direction 값이 채워진 완성된 조합
		if (idx == cctvList.size()) {
			simulate();
			return;
		}

		// cctv가 가질 수 있는 모든 방향 시도
		Cctv c = cctvList.get(idx);
		for (int d = 0; d < dirCount[c.type]; d++) {
			c.setDirection(d);
			dfs(idx + 1);
		}
	}

	// 0:상 1:우 하:2 좌:3
	public static void simulate() {
		int[][] tmp = copyMap(map);

		for (Cctv c : cctvList) {
			int dir = c.direction;

			switch (c.type) {
				case 1:
					watch(tmp, c.x, c.y, dir);
					break;

				case 2:
					// 상하
					if (dir == 0) {
						watch(tmp, c.x, c.y, 0);
						watch(tmp, c.x, c.y, 2);
					}
					// 좌우
					else {
						watch(tmp, c.x, c.y, 1);
						watch(tmp, c.x, c.y, 3);
					}
					break;
				case 3:
					// 상우
					if (dir == 0) {
						watch(tmp, c.x, c.y, 0);
						watch(tmp, c.x, c.y, 1);
					}
					// 우하
					else if (dir == 1) {
						watch(tmp, c.x, c.y, 1);
						watch(tmp, c.x, c.y, 2);
					}
					// 하좌
					else if (dir == 2) {
						watch(tmp, c.x, c.y, 2);
						watch(tmp, c.x, c.y, 3);
					}
					// 좌상
					else {
						watch(tmp, c.x, c.y, 3);
						watch(tmp, c.x, c.y, 0);
					}
					break;
				case 4:
					// 좌상우
					if (dir == 0) {
						watch(tmp, c.x, c.y, 3);
						watch(tmp, c.x, c.y, 0);
						watch(tmp, c.x, c.y, 1);
					}
					// 상우하
					else if (dir == 1) {
						watch(tmp, c.x, c.y, 0);
						watch(tmp, c.x, c.y, 1);
						watch(tmp, c.x, c.y, 2);
					}
					// 우하좌
					else if (dir == 2) {
						watch(tmp, c.x, c.y, 1);
						watch(tmp, c.x, c.y, 2);
						watch(tmp, c.x, c.y, 3);
					}
					// 하좌상
					else {
						watch(tmp, c.x, c.y, 2);
						watch(tmp, c.x, c.y, 3);
						watch(tmp, c.x, c.y, 0);
					}
					break;
				case 5:
					watch(tmp, c.x, c.y, 0);
					watch(tmp, c.x, c.y, 1);
					watch(tmp, c.x, c.y, 2);
					watch(tmp, c.x, c.y, 3);
					break;
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 0) {
					count++;
				}
			}
		}

		minCount = Math.min(minCount, count);

	}

	public static void watch(int[][] tmp, int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dy[dir];
			ny += dx[dir];

			// 범위 밖이면 종료
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				break;
			}
			// 벽 만나면 종료
			if (tmp[nx][ny] == 6) {
				break;
			}

			// 빈 칸이면 감시 표시 -1
			if (tmp[nx][ny] == 0) {
				tmp[nx][ny] = -1;
			}
		}
	}

	public static int[][] copyMap(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
}
