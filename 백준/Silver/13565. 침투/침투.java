import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int x = 0; x < N; x++) {
            if (!visited[0][x] && map[0][x] == 0) {
                dfs(0, x);
            }
        }

        boolean check = false;
        for(int i=0; i<N; i++) {
            if(visited[M-1][i]) {
                check = true;
                break;
            }
        }
        System.out.println(check ? "YES" : "NO");
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if(ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if(!visited[ny][nx] && map[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
