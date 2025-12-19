import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int s = 0; s < K; s++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            boolean[][] sticker = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = (Integer.parseInt(st.nextToken()) == 1);
                }
            }

            // 최대 4방향(0,90,180,270) 시도
            for (int rot = 0; rot < 4; rot++) {
                if (tryAttach(sticker)) break;     // 붙였으면 다음 스티커
                sticker = rotate90(sticker);       // 못 붙였으면 회전
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean tryAttach(boolean[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;

        // 스티커의 좌상단을 (x,y)에 두고 붙일 수 있는지 전 범위 탐색
        for (int x = 0; x <= N - r; x++) {
            for (int y = 0; y <= M - c; y++) {
                if (canPlace(sticker, x, y)) {
                    place(sticker, x, y);
                    return true;
                }
            }
        }
        return false;
    }

    // 겹치는 1이 없으면 true
    static boolean canPlace(boolean[][] sticker, int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] && board[x + i][y + j]) return false;
            }
        }
        return true;
    }

    // 실제로 붙이기(OR)
    static void place(boolean[][] sticker, int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j]) board[x + i][y + j] = true;
            }
        }
    }

    // 시계방향 90도 회전
    static boolean[][] rotate90(boolean[][] a) {
        int r = a.length;
        int c = a[0].length;
        boolean[][] b = new boolean[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[j][r - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}