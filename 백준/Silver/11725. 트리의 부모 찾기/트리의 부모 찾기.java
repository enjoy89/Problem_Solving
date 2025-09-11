import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        dfs(1);

        // 2번부터 출력
        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }

    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int next : tree.get(start)) {
            if(!visited[next]) {
                parent[next] = start; // 부모 노드 저장
                dfs(next);
            }
        }
    }
}
