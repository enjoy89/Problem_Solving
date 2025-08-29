import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향 그래프이므로 양쪽에 추가
        }

        dfs(1); // 1번부터 시작
        System.out.println(count-1);

    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for(int next: graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
