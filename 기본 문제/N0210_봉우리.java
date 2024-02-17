import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 * 자신의 상화좌우 숫자보다 큰 숫자는 봉우리 지역
 * 봉우리 지역의 개수를 구하라.
 */
public class N0210_봉우리 {

    // 차례대로 상하좌우 판단
    // 상: (-1,0)
    // 하: (1, 0)
    // 좌: (0, -1)
    // 우: (0, 1)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2]; // 가장자리는 0으로 초기화

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(isPeak(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static boolean isPeak(int x, int y) {
        int cur = map[x][y];

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 상하좌우 중 자신보다 큰 값이 있다면 봉우리가 아님
            if(cur <= map[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}
