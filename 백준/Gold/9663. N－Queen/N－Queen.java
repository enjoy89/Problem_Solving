import java.io.*;

public class Main {
	static int N;
	static boolean[] v1;
	static boolean[] v2;
	static boolean[] v3;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		v1 = new boolean[N]; // 열 사용 여부
		v2 = new boolean[N * 2]; // /대각선
		v3 = new boolean[N * 2]; // \대각선

		dfs(0);
		System.out.println(answer);
	}

	public static void dfs(int row) {
		if(row == N) {
			answer++;
			return;
		}
		// row 행 각 열 col에 퀸을 놓는다.
		for(int col=0; col<N; col++) {

			// 이미 같은 열/대각선에 퀸이 놓여져있으면 패스
			if(v1[col] || v2[row + col] || v3[row - col + (N-1)]) {
				continue;
			}

			// 방문 표시
			v1[col] = true;
			v2[row + col] = true;
			v3[row - col + (N-1)] = true;

			// 다음 행 탐색
			dfs(row + 1);

			// 백트래킹
			v1[col] = false;
			v2[row + col] = false;
			v3[row - col + (N-1)] = false;
		}
	}
}
