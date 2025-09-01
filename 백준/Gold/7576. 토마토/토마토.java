import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        boolean check = true;
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    check = false; // 0이 1개라도 있으면 안 익은 토마토가 있으므로 결과 -1
                }

                if(map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        if(check) {
            System.out.println(max -1);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] == 1) {
                    queue.offer(new int[]{y, x}); // 1(익은 토마토)은 모두 큐에 넣고 시작
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;
                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if(map[ny][nx] == 0) {
                        map[ny][nx] = map[cy][cx] + 1;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
