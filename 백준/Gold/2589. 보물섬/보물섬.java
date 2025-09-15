import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;
    static int[][] distance;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        distance = new int[N][M];
        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j);
                distance[i][j] = -1;
            }
        }

        int answer = 0;

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] == 'L') {
                    distance[y][x] = 0;
                    bfs(y, x);

                    int max = 1;
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<M; j++) {
                            if(max < distance[i][j]) {
                                max = distance[i][j];
                            }
                        }
                    }
                    if(answer < max) {
                        answer = max;
                    }

                    for(int i=0; i<N; i++) {
                        for(int j=0; j<M; j++) {
                            distance[i][j] = -1;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;

                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if(!visited[ny][nx] && map[ny][nx] == 'L') {
                        distance[ny][nx] = distance[cy][cx] + 1;
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
