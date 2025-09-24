import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 끊어진 줄의 개수
        int M = Integer.parseInt(st.nextToken());
        int[][] brand = new int[M][2];

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken()); // 패키지 가격 (6개)
            brand[i][1] = Integer.parseInt(st.nextToken()); // 낱개 가격

            minPackage = Math.min(minPackage, brand[i][0]); // 패키지 최저가
            minSingle = Math.min(minSingle, brand[i][1]); // 낱개 최저가
        }

        int cost1 = N * minSingle; // 낱개로만
        int cost2 = (N / 6) * minPackage + (N % 6) * minSingle; // 패키지+낱개 조합
        int cost3 = ((N+5) / 6) * minPackage;

        // 세 가지 방법 중 가장 저렴한 값
        System.out.println(Math.min(cost1, Math.min(cost2, cost3)));

    }
}
