
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;
            testCase++;

            graph = new ArrayList<>();
            visited = new boolean[n + 1];
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 무방향 그래프
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    hasCycle = false;
                    dfs(i, 0);              // parent=0 (없음)
                    if (!hasCycle) treeCount++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case ").append(testCase).append(": ");
            if (treeCount == 0) sb.append("No trees.");
            else if (treeCount == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(treeCount).append(" trees.");
            System.out.println(sb);
        }
    }

    static void dfs(int cur, int parent) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, cur);
            } else if (next != parent) {
                // 이미 방문했는데 부모가 아니면 무방향 그래프에서 사이클
                hasCycle = true;
            }
        }
    }
}