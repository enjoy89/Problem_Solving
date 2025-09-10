import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        while(q.size() > 1) {
            q.poll(); // 첫 번째 카드를 버린다

            // 제일 위에 있는 카드를 밑으로 옮긴다
            q.offer(q.poll());
        }

        System.out.println(q.poll());

    }
}
