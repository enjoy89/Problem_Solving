import java.io.*;
import java.util.*;

public class Main {

	static class Cell {
		int r;
		int c;

		Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static List<Cell> house = new ArrayList<>();
	static List<Cell> chickens = new ArrayList<>();
	static int[][] distance;
	static boolean[] selected; // 선택된 치킨집 표시
	static int N, M, H, C;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 치킨집의 개수

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					house.add(new Cell(i, j));
				} else if (num == 2) {
					chickens.add(new Cell(i, j));
				}
			}
		}

		H = house.size();
		C = chickens.size();

		distance = new int[H][C];
		selected = new boolean[C];

		// 집-치킨 거리 계산
		for (int i = 0; i < H; i++) {
			Cell h = house.get(i);
			for (int j = 0; j < C; j++) {
				Cell ch = chickens.get(j);
				distance[i][j] = Math.abs(h.r - ch.r) + Math.abs(h.c - ch.c);
			}
		}

		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(answer);

	}

	// 치킨집 C개 중 M개를 조합으로 선택
	public static void dfs(int start, int picked) {
		if (picked == M) {
			int sum = 0;
			for (int i = 0; i < H; i++) {
				int tmp = Integer.MAX_VALUE;
				for (int j = 0; j < C; j++) {
					if (selected[j]) {
						tmp = Math.min(tmp, distance[i][j]);
					}
				}
				sum += tmp;
				if (sum >= answer) {
					return;
				}

			}
			answer = Math.min(answer, sum);
			return;
		}

		if (picked + (C - start) < M) {
			return;
		}

		for (int i = start; i < C; i++) {
			selected[i] = true;
			dfs(i + 1, picked + 1);
			selected[i] = false;
		}
	}

}