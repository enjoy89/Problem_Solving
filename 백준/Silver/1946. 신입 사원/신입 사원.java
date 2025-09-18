import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] ranks = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                ranks[i][1] = Integer.parseInt(st.nextToken()); // 면접 등수
            }

            // 서류 등수 기준 오름차순 정렬
            Arrays.sort(ranks, Comparator.comparingInt(o -> o[0]));

            int count = 1;
            int bestInterviewRank = ranks[0][1];

            for(int i=1; i<N; i++) {
                if(ranks[i][1] < bestInterviewRank) {
                    count++;
                    bestInterviewRank = ranks[i][1];
                }
            }

            System.out.println(count);
        }
    }
}
