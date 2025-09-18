import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int k = 0;
    static int v = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;
        for(int y=0; y<R; y++) {
            for(int x=0; x<C; x++) {
                if(!visited[y][x] && (map[y][x] == 'k' || map[y][x] == 'v')) {
                    if (map[y][x] == 'k') {
                        k = 1;
                        v = 0;
                    } else {
                        k = 0;
                        v = 1;
                    }
                    dfs(y, x);
                    if (k > v) {
                        v = 0;
                    } else {
                        k = 0;
                    }

                    wolf += v;
                    sheep += k;
                }
            }
        }
        System.out.println(sheep + " " + wolf);

    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if(ny >= 0 && ny < R && nx >= 0 && nx < C) {
                if(!visited[ny][nx] && map[ny][nx] != '#') {
                    if(map[ny][nx] == 'k') {
                        k += 1;
                    } else if(map[ny][nx] == 'v') {
                        v += 1;
                    }
                    dfs(ny, nx);
                }
            }
        }
    }
}
