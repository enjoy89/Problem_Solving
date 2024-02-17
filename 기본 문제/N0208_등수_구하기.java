import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0208_등수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            int rank = 1;
            for(int j=0; j<N; j++) {
                if(arr[i] < arr[j]) {
                    rank++;
                }
            }
            result[i] = rank;
        }
        for(int i=0; i<N; i++) {
            System.out.print(result[i] +" ");
        }
    }
}
