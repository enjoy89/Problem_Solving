import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> queue_fire;
    static Queue<int[]> queue_person;
    static int[][] time_fire;
    static int[][] time_person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 가로
            h = Integer.parseInt(st.nextToken()); // 세로
            map = new char[h][w];

            queue_fire = new LinkedList<>();
            queue_person = new LinkedList<>();
            time_fire = new int[h][w];
            time_person = new int[h][w];

            for(int i=0; i<h; i++) {
                String line = br.readLine();
                for(int j=0; j<w; j++) {
                    map[i][j] = line.charAt(j);
                    time_fire[i][j] = -1;
                    time_person[i][j] = -1;
                }
            }

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == '*') {
                        time_fire[i][j] = 0;
                        queue_fire.offer(new int[]{i, j});
                    } else if(map[i][j] == '@') {
                        time_person[i][j] = 0;
                        queue_person.offer(new int[]{i, j});
                    }
                }
            }
            bfs_fire();
            int answer = bfs_person();
            if(answer == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }

    public static void bfs_fire() {
        while(!queue_fire.isEmpty()) {
            int[] cur = queue_fire.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < h && nx >= 0 && nx < w) {
                    if(map[ny][nx] == '.' && time_fire[ny][nx] == -1) {
                        time_fire[ny][nx] = time_fire[cy][cx] + 1;
                        queue_fire.offer(new int[]{ny, nx});
                    }
                }
            }

        }
    }

    public static int bfs_person() {
        while(!queue_person.isEmpty()) {
            int[] cur = queue_person.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    return time_person[cy][cx] + 1;
                }

                // 벽이거나 이미 이동한 곳이면 이동 불가
                if(map[ny][nx] == '#' || time_person[ny][nx] != -1) {
                    continue;
                }
                // 불이 사람보다 먼저 번진 곳은 이동 불가
                if(time_fire[ny][nx] != -1 && time_fire[ny][nx] <= time_person[cy][cx] + 1) {
                    continue;
                }
                if (map[ny][nx] == '.') {
                    time_person[ny][nx] = time_person[cy][cx] + 1;
                    queue_person.offer(new int[]{ny, nx});
                }
            }
        }
        return -1;
    }
}
