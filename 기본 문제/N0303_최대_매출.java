import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 */
public class N0303_최대_매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int count = N-K+1;
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i<count; i++) {
//
//            int sum = 0;
//            for(int j=i; j<K+i; j++) {
//                sum += arr[j];
//            }
//            if(sum > max) {
//                max = sum;
//            }
//        }

        // 슬라이딩 윈도우 알고리즘
        // 2중 for문을 사용하지 않고, K 크기의 윈도우를 옆으로 한 칸씩 미는 구조
        int sum = 0;
        // 처음 K칸의 합으로 sum 초기화
        for(int i=0; i<K; i++) {
            sum += arr[i];
        }

        int max = sum;

        // 현재 sum에서 첫 번째 요소를 빼고
        // 마지막 요소를 다시 넣어준다.
        // 그럼 윈도우 크기만큼의 합이 업데이트 된다.
        for(int i=K; i<N; i++) {
            sum += (arr[i] - arr[i-K]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
