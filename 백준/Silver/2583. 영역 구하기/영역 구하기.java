import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int dx[] = {-1, 1, 0, 0};    // 좌,우 범위를 판단
    static int dy[] = {0, 0, -1, 1};    // 상,하 범위를 판단
    static int M, N, count, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   // 직사각형의 개수

        arr = new int[M][N];
        ArrayList<Integer> area = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    arr[y][x] = 1;
                }
            }

        }

        count = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 0) {
                    count++;
                    num = 0; // 영역의 넓이
                    dfs(i, j);
                    area.add(num);
                }
            }
        }

        Collections.sort(area);
        System.out.println(count);

        for(int i=0; i<area.size(); i++){
            System.out.print(area.get(i) + " ");
        }

    }

    public static void dfs(int x, int y) {
        arr[x][y] = 1;
        num++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(checkArr(nx, ny) && arr[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean checkArr(int nx, int ny) {
        return nx >= 0 && nx < M && ny >= 0 && ny < N;

    }
}
