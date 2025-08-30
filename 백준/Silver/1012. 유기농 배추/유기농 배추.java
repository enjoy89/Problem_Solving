import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            int K = Integer.parseInt(st.nextToken()); // 위치개수

            visited = new boolean[N][M];
            map = new int[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;
            for(int y=0; y<N; y++) {
                for(int x=0; x<M; x++) {
                    if(map[y][x] == 1 && !visited[y][x]) {
                        dfs(y, x);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
