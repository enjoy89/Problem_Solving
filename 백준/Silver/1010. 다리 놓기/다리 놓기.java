import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] combination = new int[31][31];

		for (int n = 0; n <= 30; n++) {
			combination[n][0] = 1;
			combination[n][n] = 1;
			for (int r = 1; r < n; r++) {
				combination[n][r] = combination[n - 1][r - 1] + combination[n - 1][r];
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int answer = combination[m][n];
			System.out.println(answer);
		}
	}
}
