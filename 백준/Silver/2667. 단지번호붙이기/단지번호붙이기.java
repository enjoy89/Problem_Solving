import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] map;
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};    
    static int dy[] = {0, 0, -1, 1};    
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (map[i][j] == 1 & !visited[i][j]) {
                    DFS(i, j);
                    result.add(count);
                    num++;
                }
            }
        }

        System.out.println(num);
        Collections.sort(result);
        for (int count : result) {
            System.out.println(count);
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        count += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }

    private static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}