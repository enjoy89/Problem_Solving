import java.io.*;
import java.util.*;

public class Main {
    static int[] time;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(time[K]);
        System.out.println(count[K]);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        time = new int[100001];
        count = new int[100001];

        Arrays.fill(time, -1);
        time[start] = 0;
        count[start] = 1;

        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : new int[]{cur-1, cur+1, cur*2}) {
                if(next >= 0 && next <= 100000) {
                    // 처음 방문
                    if(time[next] == -1) {
                        time[next] = time[cur] + 1;
                        count[next] = count[cur]; // 방법 개수 그대로 복사
                        queue.offer(next);
                    }
                    // 이미 방문했지만 같은 시간에 도달
                    else if(time[next] == time[cur] + 1) {
                        count[next] += count[cur];
                    }
                }
            }
        }
    }
}
