import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] A = new int[H][W];
        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 B를 그대로 A에 복사함
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int num = B[i][j];

                if (num == 0) {
                    continue;
                }

                // 1. 두 배열 모두에 포함되는 경우
                if (isContains_area1(i, j) && isContains_area2(i, j)) {
                    A[i][j] = num - A[i - X][j - Y];
                }

                // 2. 두 배열 중 하나만 포함되는 경우
                if (isContains_area1(i, j) && !isContains_area2(i, j)) {
                    A[i][j] = num;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isContains_area1(int i, int j) {
        return (i >= 0 && j >= 0 && i < H && j < W);
    }

    public static boolean isContains_area2(int i, int j) {
        return (i >= X && j >= Y && i < H + X && j < W + Y);
    }
}
