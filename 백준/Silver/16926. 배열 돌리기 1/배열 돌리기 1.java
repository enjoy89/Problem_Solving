import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
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

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < count; j++) {
                int temp = A[j][j];  // 시작점 숫자 저장

                // 왼쪽으로 밀기
                for (int k = j; k < M - j - 1; k++) {
                    A[j][k] = A[j][k + 1];
                }
                // 위쪽으로 밀기
                for (int k = j; k < N - 1 - j; k++) {
                    A[k][M - j - 1] = A[k + 1][M - j - 1];
                }
                // 오른쪽으로 밀기
                for (int k = M - j - 1; k > j; k--) {
                    A[N - 1 - j][k] = A[N - 1 - j][k - 1];
                }
                // 아래쪽으로 밀기
                for (int k = N - j - 1; k > j; k--) {
                    A[k][j] = A[k - 1][j];
                }
                A[j + 1][j] = temp;
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
