import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static char[][] board;

    static int[][] fire_dist;
    static int[][] jh_dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        fire_dist = new int[R][C];
        Queue<int[]> fire_queue = new LinkedList<>();

        jh_dist = new int[R][C];
        Queue<int[]> jh_queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(fire_dist[i], -1);
            Arrays.fill(jh_dist[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                char c = line[j].charAt(0);
                if (c == 'J') {
                    jh_dist[i][j] = 0;
                    jh_queue.offer(new int[] { i, j });
                } else if (c == 'F') {
                    fire_dist[i][j] = 0;
                    fire_queue.offer(new int[] { i, j });
                }
                board[i][j] = c;
            }
        }

        fire_bfs(fire_queue);
        int result = jh_bfs(jh_queue);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    public static void fire_bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isRange(nx, ny) && board[nx][ny] != '#' && fire_dist[nx][ny] == -1) {
                    fire_dist[nx][ny] = fire_dist[cx][cy] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }
    }

    public static int jh_bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!isRange(nx, ny)) {
                    return jh_dist[cx][cy] + 1;
                }

                if (isRange(nx, ny) && board[nx][ny] != '#' && jh_dist[nx][ny] == -1) {
                    // 지훈이보다 불이 먼저 도착하면 방문 불가능
                    if (fire_dist[nx][ny] == -1 || jh_dist[cx][cy] + 1 < fire_dist[nx][ny]) {
                        jh_dist[nx][ny] = jh_dist[cx][cy] + 1;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}
