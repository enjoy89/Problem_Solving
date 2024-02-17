import java.io.*;

/**
 * 2024-02-17
 */
public class N0204_피보나치_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        arr[0] = arr[1] = 1;

        for(int i=2; i<N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
