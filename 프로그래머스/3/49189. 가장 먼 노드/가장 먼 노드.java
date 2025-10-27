import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] result;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        result = new int[n+1];
        bfs(1);
        int max = 0;
        int answer = 0;
        for(int i=0; i<=n; i++) {
            max = Math.max(max, result[i]);
        }
        for(int i=0; i<=n; i++) {
            if(max == result[i]) {
                answer++;
            }
        }
        
        return answer;
 
    }
    
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        int count = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    result[next] = result[cur] + 1;
                }
            }
        }
               
    }
}