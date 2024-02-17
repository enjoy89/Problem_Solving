import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0206_뒤집은_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String tmp = str[i];
            int n = Integer.parseInt(new StringBuilder(tmp).reverse().toString());
            if(isPrimeNum(n)) {
                result.add(n);
            }
        }

        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    public static boolean isPrimeNum(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}

