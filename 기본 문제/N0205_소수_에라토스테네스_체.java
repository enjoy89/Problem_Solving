import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0205_소수_에라토스테네스_체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int count = 0;

        // 2부터 시작하여 N까지 2의 배수, 3의 배수 ... N의 배수를 모두 1로 체크한다.
        for(int i=2; i<=N; i++) {
            if(arr[i] == 0) {
                count++;
                for(int j=i; j<=N; j+=i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
