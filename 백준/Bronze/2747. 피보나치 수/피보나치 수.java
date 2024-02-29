import java.io.*;
import java.util.*;

public class Main {
    static int[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n+1];
        recursive(n);
        System.out.println(fibo[n]);
    }

    // 메모제이션 재귀 방법
    public static int recursive(int n) {
        if(fibo[n] != 0) {
            return fibo[n];
        } else if(n==1) {
            return fibo[1] = 1;
        } else if(n==2) {
            return fibo[2] = 1;
        } else if(n==0) {
            return fibo[0] = 0;
        } else {
            return fibo[n] = recursive(n-2) + recursive(n-1);
        }
    }
}
