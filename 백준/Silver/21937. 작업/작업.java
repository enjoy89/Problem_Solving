import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // 반대로 저장
        }

        int X = Integer.parseInt(br.readLine());
        dfs(X);
        System.out.println(count);

    }

    public static void dfs(int cur) {
        visited[cur] = true;

        for(int next : graph.get(cur)) {
            if(!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
