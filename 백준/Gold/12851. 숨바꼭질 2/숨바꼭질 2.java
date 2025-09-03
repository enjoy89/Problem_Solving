import java.io.*;
import java.util.*;

public class Main {
    static int[] count;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(time[K]);
        System.out.println(count[K]);
    }

    // 최소 시간으로 가는 방법의 수
    // 최소 시간
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        count = new int[100001];
        time = new int[100001];

        Arrays.fill(time, -1);
        time[start] = 0;
        count[start] = 1;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : new int[] {cur-1, cur+1, cur*2}) {
                if(next >= 0 && next <=100000) {
                    // 처음 방문하는 경우
                    if(time[next] == -1) {
                        time[next] = time[cur] + 1;
                        count[next] = count[cur];
                        queue.offer(next);
                    } else if(time[next] == time[cur] + 1) {
                        count[next] += count[cur];
                    }
                }
            }
        }

    }
}
