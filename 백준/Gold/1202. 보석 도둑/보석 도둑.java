import java.io.*;
import java.util.*;

public class Main {

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            // 무게 오름차순, 무게 같으면 가격 내림차순
            if (this.weight != o.weight) return Integer.compare(this.weight, o.weight);
            return Integer.compare(o.price, this.price);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 수
        int K = Integer.parseInt(st.nextToken()); // 가방 수

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        // 가방 용량 오름차순
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0L;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int capacity = bags[i];

            while (idx < N && jewels[idx].weight <= capacity) {
                pq.offer(jewels[idx].price);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}