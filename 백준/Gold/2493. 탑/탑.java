import java.io.*;
import java.util.*;

public class Main {

	static class Tower {
		int index;
		int height;

		Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Tower[] towers = new Tower[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			Tower tower = new Tower(i, Integer.parseInt(st.nextToken()));
			towers[i] = tower;
		}

		Deque<Tower> stack = new ArrayDeque<>();
		int[] answer = new int[N + 1];

		for (int i = N; i > 0; i--) {
			Tower cur = towers[i];

			while (!stack.isEmpty() && stack.peek().height <= cur.height) {
				answer[stack.pop().index] = cur.index; // 수신 처리
			}

			stack.push(cur);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);

	}
}
