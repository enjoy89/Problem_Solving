import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                count++;
            }
            // 끝자리가 1이면 1의 자리 버림
            else if (B % 10 == 1) {
                B /= 10;
                count++;
            }
            // 더 이상 아무것도 못 함
            else {
                break;
            }

            if(A == B) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }
}
