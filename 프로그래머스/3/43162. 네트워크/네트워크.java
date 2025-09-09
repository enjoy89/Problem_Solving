import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList<>();
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            List<Integer> nodes = graph.get(i);
            for(int node : nodes) {
                if(!visited[node]) {
                    dfs(node);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void dfs(int start) {
        visited[start] = true;
        
        for(int next: graph.get(start)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}