import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    static int houseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String[] nums = br.readLine().split("");
            for(int j=0; j<nums.length; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }

        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(int y=0; y<N; y++) {
            for(int x=0; x<N; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    houseCount = 1;
                    dfs(y, x);
                    result.add(houseCount);
                    count++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for(int num : result) {
            System.out.println(num);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    houseCount++;
                    dfs(ny, nx);
                }
            }
        }
    }
}
