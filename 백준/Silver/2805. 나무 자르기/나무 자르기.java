import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수 N
        int M = Integer.parseInt(st.nextToken()); // 가져갈 나무의 길이 M

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max) {
                max = trees[i];
            }
        }
        // 나무의 높이의 합은 M보다 크거나 같다
        int min = 0;
        int result = 0;
        while(min <= max) {
            int mid = (min+max)/2;
            long sum = 0; // 나무의 높이의 합
            for(int i=0; i<N; i++) {
                if(trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }
            if(sum >= M) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }

}
