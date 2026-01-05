import java.io.*;
import java.util.*;

public class Main {

    // 북,동,남,서
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 0:북 1:동 2:남 3:서

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {

            // 1. 현재 칸이 청소되지 않은 경우, 청소한다.
            if (board[r][c] == 0) {
                board[r][c] = 2; // 청소 완료 표시
                count++;
            }

            boolean moved = false;

            // 2. 현재 칸의 주변 4칸 중, 청소되지 않은 빈 칸이 있는지 조사
            for (int i = 0; i < 4; i++) {
                // 반시계 방향으로 회전
                d = (d + 3) % 4;

                int nr = r + dx[d];
                int nc = c + dy[d];

                // 2-1. 빈 칸이 있으면 한 칸 전진한다.
                if (isRange(nr, nc) && board[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) {
                continue;
            }

            // 3. 빈 칸이 없는 경우
            int[] b = back(r, c, d);
            int backR = b[0];
            int backC = b[1];

            // 3-1. 뒤쪽이 벽이면 작동을 멈춘다.
            if (!isRange(backR, backC) || board[backR][backC] == 1) {
                break;
            }
            // 3-2.후진이 가능하면 후진한다.
            else {
                r = backR;
                c = backC;
            }
        }

        System.out.println(count);

    }

    // 뒤로 한 칸 후진
    public static int[] back(int r, int c, int d) {
        int backDir = (d + 2) % 4;
        return new int[] { r + dx[backDir], c + dy[backDir] };

    }

    public static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}
