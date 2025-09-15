import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static int N;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 헛간의 개수
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            map.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        bfs(1);

        int max = 0;
        int index = 0;
        int count = 0;
        for(int i=0; i<N+1; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
                count = 1;
            } else if(max == distance[i]) {
                count++;
            }
        }
        System.out.println(index+ " " + distance[index] + " " + count);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        distance = new int[N+1];

        queue.offer(start);
        distance[start] = 0;
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next: map.get(cur)) {
                if(!visited[next]) {
                    distance[next] = distance[cur] + 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
