import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        BFS(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();    
        queue.offer(new int[]{x, y});  

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (checkRange(nx, ny)) {
                    if(arr[nx][ny] != 0 && !visited[nx][ny]) {
                        arr[nx][ny] = arr[curr[0]][curr[1]] + 1; 
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}