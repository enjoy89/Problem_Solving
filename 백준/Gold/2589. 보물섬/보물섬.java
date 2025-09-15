import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] == 'L') {
                    answer = Math.max(answer, bfs(y, x));
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        int max = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;

                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if(!visited[ny][nx] && map[ny][nx] == 'L') {
                        dist[ny][nx] = dist[cy][cx] + 1;
                        visited[ny][nx] = true;
                        max = Math.max(max, dist[ny][nx]);
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return max;
    }
}
