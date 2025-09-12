import java.io.*;
import java.util.*;

public class Main {
    static int A, B, M;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[100001];
        bfs(N);
        System.out.println(distance[M]);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : new int[]{cur - 1, cur + 1, cur - A, cur + A, cur - B, cur + B, cur * A, cur * B}) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
