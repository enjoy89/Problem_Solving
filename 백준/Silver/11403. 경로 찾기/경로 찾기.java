import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int N;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            bfs(i);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
//        visited[start] = true; // 자기 자신도 탐색 가능하도록
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next=0; next<N; next++) {
                if(!visited[next] && graph[cur][next] == 1) {
                    visited[next] = true;
                    result[start][next] = 1;
                    queue.offer(next);
                }
            }
        }

    }
}
