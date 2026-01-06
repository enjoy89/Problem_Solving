import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static char[] direction;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1; // 사과 표시
        }

        direction = new char[10001];
        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            direction[idx] = dir;
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[] { 1, 1 });
        visited[1][1] = true;

        int dir = 1;
        int time = 0;
        while (true) {

            time++; // 1초 증가

            int[] head = snake.peekFirst();
            int cx = head[0];
            int cy = head[1];
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            // 벽 or 몸 충돌이면 종료
            if (!isRange(nx, ny) || visited[nx][ny]) {
                break;
            }

            // 머리 이동
            snake.addFirst(new int[] { nx, ny });
            visited[nx][ny] = true; // 방문 표시

            // 사과가 있다면, 꼬리 유지
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 제거
            }
            // 사과가 없다면, 꼬리 제거
            else {
                int[] tail = snake.pollLast();
                visited[tail[0]][tail[1]] = false;
            }

            // 해당 초가 끝난 뒤 회전
            if (direction[time] != 0) {
                // 오른쪽으로 회전
                if (direction[time] == 'D') {
                    dir = (dir + 1) % 4;
                }
                // 왼쪽으로 회전
                else {
                    dir = (dir + 3) % 4;
                }
            }
        }

        System.out.println(time);

    }

    public static boolean isRange(int x, int y) {
        return x >= 1 && x < N + 1 && y >= 1 && y < N + 1;
    }
}
