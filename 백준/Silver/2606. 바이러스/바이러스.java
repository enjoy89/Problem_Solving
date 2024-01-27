import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list[start].add(end);
            list[end].add(start);
        }
        dfs(1);
        System.out.println(count-1);
        
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        count++;
        
        for(int i : list[node]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}