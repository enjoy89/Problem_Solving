import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
             map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int y=0; y<M; y++) {
            for(int x=0; x<N; x++) {
                if(!visited[y][x] && map[y][x] == 1) {
                    dfs(y, x);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<8; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if(ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if(!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
