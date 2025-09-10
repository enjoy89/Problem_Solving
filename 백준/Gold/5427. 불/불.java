import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int w, h;
    static int[][] fireTime;
    static int[][] personTime;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static Queue<int[]> fireQueue;
    static Queue<int[]> personQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int t = 0; t <T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 가로
            h = Integer.parseInt(st.nextToken()); // 세로

            map = new char[h][w];
            fireTime = new int[h][w];
            personTime = new int[h][w];
            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            for(int i=0; i<h; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<str.length; j++) {
                    map[i][j] = str[j].charAt(0);
                    fireTime[i][j] = -1; // 초기화
                    personTime[i][j] = -1; // 초기화
                }
            }

            for(int y=0; y<h; y++) {
                for(int x=0; x<w; x++) {
                    if(map[y][x] == '*') {
                        fireQueue.offer(new int[]{y, x});
                        fireTime[y][x] = 0;
                    } else if(map[y][x] == '@') {
                        personQueue.offer(new int[]{y, x});
                        personTime[y][x] = 0;
                    }
                }
            }

            bfsFire();
            int result = bfsPerson();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }

    }

    public static int bfsPerson() {
        while(!personQueue.isEmpty()) {
            int[] cur = personQueue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;

                // 탈출 성공
                if(ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    return personTime[cy][cx] + 1;
                }

                // 벽이거나 이미 왔던 곳은 이동 불가
                if(map[ny][nx] == '#' || personTime[ny][nx] != -1) {
                    continue; // 건너뜀
                }

                // 불이 이미 와있거나 동시에 도착한다면 이동 불가
                if(fireTime[ny][nx] != -1 && fireTime[ny][nx] <= personTime[cy][cx]+1) {
                    continue; // 건너뜀
                }

                // 이동 가능
                personTime[ny][nx] =  personTime[cy][cx] + 1;
                personQueue.offer(new int[]{ny, nx});
            }
        }

        return -1; // 탈출 실패
    }

    public static void bfsFire() {
        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;
                if(ny >= 0 && ny < h && nx >= 0 && nx < w) {
                    if(map[ny][nx] == '.' && fireTime[ny][nx] == -1) {
                        fireTime[ny][nx] = fireTime[cy][cx] + 1;
                        fireQueue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
