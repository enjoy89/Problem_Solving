import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] dist;
    static int n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로크기
        m = Integer.parseInt(st.nextToken()); // 가로크기
        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 2) {
                    bfs(y, x);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    dist[i][j] = 0;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        dist[y][x] = 0;
        visited[y][x] = true;
        queue.offer(new int[] {y, x});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;

                if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if(!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        dist[ny][nx]  = dist[cy][cx] + 1;
                        queue.offer(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}
