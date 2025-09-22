import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        count = new int[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            // A가 B를 신뢰한다 -> B 해킹 하면서 A 해킹 가능
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        // 모든 노드에서 시작해서 해킹할 수 있는 수를 구함
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            count[i] = bfs(i);
        }

        int max = Arrays.stream(count).max().getAsInt();
        for(int i=1; i<=N; i++) {
            if(count[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        int cnt = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: graph.get(cur)) {
                if(!visited[next]) {
                    cnt++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return cnt;
    }
}
