import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 입력 배열을 오름차순으로 정렬한다.
        // 시작 시간을 기준으로 정렬하고, 이가 같다면 끝나는 시간으로 정렬해준다.
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);   // 배열의 첫 번째 end값을 큐에 넣음

        // 배열의 start값이 큐의 peek 값보다 작거나 같다면 뺀다.
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= arr[i][0]) {
                queue.poll();
            }
            queue.add(arr[i][1]);
        }

        System.out.println(queue.size());

    }
}