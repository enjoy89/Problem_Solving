import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String[] chars = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = chars[j].charAt(0);
            }
        }
     
        int answer1 = 0;
        int answer2 = 0;

        // 적록색약이 아닌 사람이 본 구역의 수
        int count_r = 0;
        int count_g = 0;
        int count_b = 0;
        for(int y=0; y<N; y++) {
            for(int x=0; x<N; x++) {
                if(map[y][x] == 'R' && !visited[y][x]) {
                    dfs(y, x, 'R');
                    count_r++;
                }

                if(map[y][x] == 'G' && !visited[y][x]) {
                    dfs(y, x, 'G');
                    count_g++;
                }

                if(map[y][x] == 'B' && !visited[y][x]) {
                    dfs(y, x, 'B');
                    count_b++;
                }
            }
        }

        answer1 = count_r + count_g + count_b;

        // 방문 배열 초기화
        visited = new boolean[N][N];

        // 빨강(R)를 모두 초록(G)으로 바꿈
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        count_r = 0;
        count_g = 0;
        count_b = 0;
        for(int y=0; y<N; y++) {
            for(int x=0; x<N; x++) {
                if(map[y][x] == 'R' && !visited[y][x]) {
                    dfs(y, x, 'R');
                    count_r++;
                }

                if(map[y][x] == 'G' && !visited[y][x]) {
                    dfs(y, x, 'G');
                    count_g++;
                }

                if(map[y][x] == 'B' && !visited[y][x]) {
                    dfs(y, x, 'B');
                    count_b++;
                }
            }
        }
        answer2 =  count_r + count_g + count_b;

        System.out.println(answer1 + " " + answer2);

    }

    // c 문자 탐색
    public static void dfs(int y, int x, char c) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];

            if(ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == c) {
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx, c);
                }
            }
        }
    }
}
