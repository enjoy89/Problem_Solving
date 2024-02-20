import java.io.*;
import java.util.*;

/**
 * 2024-02-20
 */
public class N0405_K번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N개의 자연수 중에서 3개를 뽑는 모든 경우의 수를 고려해야 하므로
        // 3중 for문 사용
        // 중복을 허용하지 않고, 정렬되어야 하므로 TreeSet 사용
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int l=j+1; l<N; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int result = -1;

        int count = 0;
        for(int i : set) {
            count++;
            if(count == K) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
