import java.util.*;
import java.io.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시작위치
        K = Integer.parseInt(st.nextToken()); // 도착 위치

        bfs(N);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] dist = new int[1000001];

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == K) {
                System.out.println(dist[cur]);
            }

            for(int next: new int[]{cur-1, cur+1, cur*2}) {
                if(next >=0 && next <= 100000 && !visited[next]) {
                    dist[next] = dist[cur] + 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
