import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static char[][] board;

    static boolean[][] fire_visited;
    static int[][] fire;
    static boolean[][] jh_visited;
    static int[][] jh;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        fire_visited = new boolean[R][C];
        fire = new int[R][C];
        Queue<int[]> fire_queue = new LinkedList<>();

        jh_visited = new boolean[R][C];
        jh = new int[R][C];
        Queue<int[]> jh_queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jh[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                char c = line[j].charAt(0);
                if (c == 'J') {
                    jh[i][j] = 0;
                    jh_queue.offer(new int[] { i, j });
                    jh_visited[i][j] = true;
                } else if (c == 'F') {
                    fire[i][j] = 0;
                    fire_queue.offer(new int[] { i, j });
                    fire_visited[i][j] = true;
                }
                board[i][j] = c;
            }
        }

        fire_bfs(fire_queue);
        jh_bfs(jh_queue);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                    if (jh[i][j] != -1) {
                        answer = Math.min(answer, jh[i][j]);
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer + 1);
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

                if (isRange(nx, ny) && board[nx][ny] != '#' && !fire_visited[nx][ny]) {
                    fire_visited[nx][ny] = true;
                    fire[nx][ny] = fire[cx][cy] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }
    }

    public static void jh_bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isRange(nx, ny) && board[nx][ny] != '#' && !jh_visited[nx][ny]) {
                    // 지훈이보다 불이 먼저 도착하면 방문 불가능
                    if (!fire_visited[nx][ny] || jh[cx][cy] + 1 < fire[nx][ny]) {
                        jh_visited[nx][ny] = true;
                        jh[nx][ny] = jh[cx][cy] + 1;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }

    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}
