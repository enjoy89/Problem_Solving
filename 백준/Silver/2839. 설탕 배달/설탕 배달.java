import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N > 0) {
            if (N >= 5) {
                if (N % 5 == 0) {
                    result += N / 5;
                    N %= 5;
                } else if(N % 3 != 0) {
                    N -= 5;
                    result++;
                } else {
                    N -= 3;
                    result++;
                }
            } else {
                if(N >= 3) {
                    N -= 3;
                    result++;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);
    }
}
