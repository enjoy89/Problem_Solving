import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());   // 회전 수

        int count = Math.min(N, M) / 2;  // 회전시켜야 하는 그룹 수
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            int si = 0, sj = 0;
            int ei = N - 1, ej = M - 1;

            while (!(si == N / 2 || sj == M / 2)) {

                int first = A[si][sj];

                // 상
                for (int j = sj + 1; j <= ej; j++) {
                    A[si][j - 1] = A[si][j];
                }

                // 우
                for (int i = si + 1; i <= ei; i++) {
                    A[i - 1][ej] = A[i][ej];
                }

                // 하
                for (int j = ej - 1; j >= sj; j--) {
                    A[ei][j + 1] = A[ei][j];
                }

                // 좌
                for (int i = ei - 1; i >= si; i--) {
                    A[i + 1][sj] = A[i][sj];
                }

                A[si + 1][sj] = first;

                si++;
                sj++;
                ei--;
                ej--;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
