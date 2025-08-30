import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수 
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호

        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false); // 배열 초기화
        bfs(V);

    }

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int next: graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        // 1. 시작 노드를 방문처리 한다.
        visited[node] = true;
        // 2. 시작 노드를 큐에 넣는다.
        queue.offer(node);


        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 3. 큐에서 노드를 하나 꺼낸다.
            int now = queue.poll();
            System.out.print(now + " ");

            // 4. 꺼낸 노드와 인접한 노드 중 아직 방문하지 않은 노드를 방문처리 하고, 큐에 넣는다.
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
