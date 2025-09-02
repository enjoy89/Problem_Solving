import java.io.*;
import java.util.*;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] result = new int[100001]; // 걸리는 시간을 누적해서 기록

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                System.out.println(result[cur]);
                
            }
            for(int next : new int[]{cur-1, cur+1, cur*2}) {
                if(next>=0 && next <= 100000 && !visited[next]) {
                    result[next] = result[cur] + 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
