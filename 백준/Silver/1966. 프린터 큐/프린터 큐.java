import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 알고싶은 문서의 인덱스

            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Document> pq = new PriorityQueue<>(
                    (d1, d2) -> Integer.compare(d2.priority, d1.priority)
            );

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                Document doc = new Document(i, priority);
                q.offer(doc);
                pq.offer(doc);
            }

            int count = 0;
            while(!q.isEmpty()) {
                Document cur = q.poll();
                Document front = pq.peek();

                if(cur.priority == front.priority) {
                    count++;
                    pq.poll();

                    if(cur.index == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.offer(cur);
                }
            }
        }
    }
}
