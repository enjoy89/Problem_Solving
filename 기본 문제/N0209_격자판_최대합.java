import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0209_격자판_최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        int result = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 행과 열의 합 구하기
        int sum_row, sum_col;
        for(int i=0; i<N; i++) {
            sum_row = sum_col = 0;
            for(int j=0; j<N; j++) {
                sum_row += arr[i][j];
                sum_col += arr[j][i];
            }

            result = Math.max(result, sum_row);
            result = Math.max(result, sum_col);
        }



        // 두 대각선의 합 구하기
        int sum_l = 0;
        int sum_r = 0;
        for(int i=0; i<N; i++) {
            sum_l += arr[i][i];
            sum_r += arr[i][N-i-1];
        }

        result = Math.max(result, sum_l);
        result = Math.max(result, sum_r);

        System.out.println(result);

    }
}
