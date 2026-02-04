import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };
    static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };
    static int[][] map;
    static boolean[][] visited;
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (h == 0 && w == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }

        }
    }

}
