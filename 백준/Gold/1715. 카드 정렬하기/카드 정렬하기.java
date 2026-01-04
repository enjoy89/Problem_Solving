import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());

	        PriorityQueue<Long> pq = new PriorityQueue<>();
	        for (int i = 0; i < N; i++) {
	            pq.offer(Long.parseLong(br.readLine()));
	        }

	        if (N == 1) {
	            System.out.println(0);
	            return;
	        }

	        long total = 0;
	        while (pq.size() > 1) {
	            long a = pq.poll();
	            long b = pq.poll();
	            long sum = a + b;
	            total += sum;
	            pq.offer(sum);
	        }

	        System.out.println(total);
	}
}
