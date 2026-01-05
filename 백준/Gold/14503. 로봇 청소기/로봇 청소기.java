import java.io.*;
import java.util.*;

/**
 * 260105 / 백준 14593 로봇 청소기 / 골드 5
 * 1. 현재 칸이 청소되어 있지 않으면, 현재 칸을 청소한다.
 * 2. 현재 칸의 주변 4칸 중, 청소되지 않은 빈 칸이 있는 경우
 * 2-1. 반시계 방향으로 90도 회전하며, 바라보는 방향의 앞쪽 칸이 청소되어 있지 않은 빈 칸인 경우 한 칸 전진한다.
 * 3. 현재 칸의 주변 4칸 중, 청소되지 않은 빈 칸이 없는 경우
 * 3-1. 바라보는 방향의 뒤쪽 칸이 벽이면 작동을 멈춘다.
 * 3-2. 바라보는 방향으로 후진이 가능하면 후진한다.
 */
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

                int nx = r + dx[d];
                int ny = c + dy[d];

                // 2-1. 빈 칸이 있으면 한 칸 전진한다.
                if (isRange(nx, ny) && board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (moved) {
                continue;
            }

            // 3. 빈 칸이 없는 경우
            int[] b = back(r, c, d);
            int bx = b[0];
            int by = b[1];

            // 3-1. 뒤쪽이 벽이면 작동을 멈춘다.
            if (!isRange(bx, by) || board[bx][by] == 1) {
                break;
            }
            // 3-2.후진이 가능하면 후진한다.
            else {
                r = bx;
                c = by;
            }
        }

        System.out.println(count);

    }

    // 뒤로 한 칸 후진
    public static int[] back(int x, int y, int d) {
        int backDir = (d + 2) % 4;
        int nx = x + dx[backDir];
        int ny = y + dy[backDir];

        return new int[] { nx, ny };

    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
