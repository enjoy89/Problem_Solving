import java.io.*;
import java.util.*;

/**
 * 2024-02-19
 * 주어진 수열에서 최대 k번 0을 1로 변경할 수 있다.
 * 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾아라.
 */
public class N0306_최대_길이_연속부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수열의 길이
        int k = Integer.parseInt(st.nextToken());   // 최대 변경 횟수
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, change = 0;
        int max = Integer.MIN_VALUE;

        // 수열의 길이: rt - lt + 1
        // rt가 가리키는 요소가 0이라면 1로 바꾸고, change++;
        // 만약 k를 초과한다면 lt의 위치를 조정한다.
        for(int rt=0; rt<N; rt++) {
            int length = 0;

            if(arr[rt] == 0) {
                change++;
                // 변경 횟수가 k를 초과한다면
                // lt의 위치를 0까지 증가시키고 (1로 바꿨던 부분을 다시 0으로 바꾸는 의미)
                // change--
                while(change > k) {
                    if(arr[lt] == 0) {
                        change--;
                    }
                    lt++;
                }
            }
            length = rt - lt + 1;

            if(length > max) {
                max = length;
            }
        }

        System.out.println(max);
    }
}
