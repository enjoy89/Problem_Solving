import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElse(1);
        List<Integer> heights = new ArrayList<>();
        for(int height=1; height<=max; height++) {
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] < height) {
                        map[i][j] = 0; // 잠긴 곳을 0으로 표시
                        visited[i][j] = true; // 탐색 후보에서 제거
                    }
                }
            }

            int count = 0;
            for(int y=0; y<N; y++) {
                for(int x=0; x<N; x++) {
                    if(!visited[y][x] && map[y][x] != 0) {
                        count++;
                        dfs(y, x);
                    }
                }
            }
            heights.add(count);
        }

        System.out.println(heights.stream().mapToInt(Integer::intValue).max().orElse(0));
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if(!visited[ny][nx] && map[ny][nx] != 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
