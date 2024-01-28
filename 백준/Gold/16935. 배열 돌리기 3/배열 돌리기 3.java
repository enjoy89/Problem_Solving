import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] calculations = new int[R];

        for (int i = 0; i < R; i++) {
            calculations[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            int calculations_num = calculations[i];

            switch (calculations_num) {
                case 1:
                    calculation_1();
                    break;
                case 2:
                    calculation_2();
                    break;
                case 3:
                    calculation_3();
                    break;
                case 4:
                    calculation_4();
                    break;
                case 5:
                    calculation_5();
                    break;
                case 6:
                    calculation_6();
                    break;
            }
        }
        print(A);
    }

    public static int[][] calculation_1() {
        int x_size = A.length;
        int y_size = A[0].length;
        int e = x_size - 1;
        for (int i = 0; i < x_size / 2; i++) {
            for (int j = 0; j < y_size; j++) {
                int temp = A[i][j];
                A[i][j] = A[e - i][j];
                A[e - i][j] = temp;
            }
        }
        return A;
    }

    public static int[][] calculation_2() {
        int x_size = A.length;
        int y_size = A[0].length;
        int e = y_size - 1;
        for (int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_size / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][e - j];
                A[i][e - j] = temp;
            }
        }
        return A;
    }

    public static int[][] calculation_3() {
        int x_size = A.length;
        int y_size = A[0].length;

        int[][] result = new int[y_size][x_size];
        for (int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_size; j++) {
                result[j][x_size - 1 - i] = A[i][j];
            }
        }
        A = result;
        return A;
    }

    public static int[][] calculation_4() {
        int x_size = A.length;
        int y_size = A[0].length;

        int[][] result = new int[y_size][x_size];
        for (int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_size; j++) {
                result[y_size - 1 - j][i] = A[i][j];
            }
        }
        A = result;
        return A;
    }

    public static int[][] calculation_5() {
        int x_size = A.length;
        int y_size = A[0].length;
        int[][] temp = new int[x_size][y_size];

        int x_mid_size = x_size / 2;
        int y_mid_size = y_size / 2;

        // 그룹 1 -> 그룹 2
        for (int i = 0; i < x_mid_size; i++) {
            for (int j = 0; j < y_mid_size; j++) {
                temp[i][j + y_mid_size] = A[i][j];
            }
        }

        // 그룹 2-> 그룹 3
        for (int i = 0; i < x_mid_size; i++) {
            for (int j = y_mid_size; j < y_size; j++) {
                temp[x_mid_size + i][j] = A[i][j];
            }
        }

        // 그룹 3 -> 그룹 4
        for (int i = x_mid_size; i < x_size; i++) {
            for (int j = y_mid_size; j < y_size; j++) {
                temp[i][j - y_mid_size] = A[i][j];
            }
        }

        // 그룹 4 -> 그룹 1
        for (int i = x_mid_size; i < x_size; i++) {
            for (int j = 0; j < y_mid_size; j++) {
                temp[i - x_mid_size][j] = A[i][j];
            }
        }

        A = temp;
        return A;
    }

    public static int[][] calculation_6() {
        int x_size = A.length;
        int y_size = A[0].length;
        int[][] temp = new int[x_size][y_size];

        int x_mid_size = x_size / 2;
        int y_mid_size = y_size / 2;

        // 그룹 1 -> 그룹 4
        for (int i = 0; i < x_mid_size; i++) {
            for (int j = 0; j < y_mid_size; j++) {
                temp[i + x_mid_size][j] = A[i][j];
            }
        }

        // 그룹 4 -> 그룹 3
        for (int i = x_mid_size; i < x_size; i++) {
            for (int j = 0; j < y_mid_size; j++) {
                temp[i][j + y_mid_size] = A[i][j];
            }
        }

        // 그룹 3 -> 그룹 2
        for (int i = x_mid_size; i < x_size; i++) {
            for (int j = y_mid_size; j < y_size; j++) {
                temp[i - x_mid_size][j] = A[i][j];
            }
        }

        // 그룹 2 -> 그룹 1
        for (int i = 0; i < x_mid_size; i++) {
            for (int j = y_mid_size; j < y_size; j++) {
                temp[i][j - y_mid_size] = A[i][j];
            }
        }

        A = temp;
        return A;
    }

    public static void print(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
