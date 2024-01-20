import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<int[]> queue;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   // 문서의 개수
            int M = Integer.parseInt(st.nextToken());   // 문서의 순서

            st = new StringTokenizer(br.readLine());    // 문서의 중요도
            queue = new LinkedList<>();
            
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{j, num});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] first = queue.poll();
                boolean isMax = true;

                // 현재 문서보다 중요도가 높은 문서가 있다면 맨 뒤로 넘김
                for (int j = 0; j < queue.size(); j++) {
                    if (first[1] < queue.get(j)[1]) {
                        queue.offer(first);

                        for (int z = 0; z < j; z++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    continue;
                }

                count++;
                if (first[0] == M) {
                    sb.append(count).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}