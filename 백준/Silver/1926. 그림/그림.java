import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n, m;
    static int image = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로크기
        m = Integer.parseInt(st.nextToken()); // 가로크기

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        List<Integer> images = new ArrayList<>();
        for(int y=0; y<n; y++) {
            for(int x=0; x<m; x++) {
                if(!visited[y][x] && map[y][x] == 1) {
                    image = 1;
                    dfs(y, x);
                    images.add(image);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(images.stream().max(Integer::compareTo).orElse(0));

    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if(!visited[ny][nx] && map[ny][nx] == 1) {
                    image++;
                    dfs(ny, nx);
                }
            }
        }
    }
}
