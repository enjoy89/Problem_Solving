import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0202_보이는_학생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        int max = arr[0];
        for(int i=1; i<N; i++) {
            if(arr[i] > max) {
                count++;
                max = arr[i];
            }
        }

        System.out.println(count);
    }
}
