import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 300으로 나누어 떨어질 때까지 60, 10을 뺀다
        int A = 0; // 300
        int B = 0; // 60
        int C = 0; // 10
        while(T >= 0) {
            if(T % 300 == 0) {
                A += T / 300;
                System.out.println(A + " " + B + " " + C);
                return;
            }
            if(T >= 60) {
                T -= 60;
                B++;
            } else {
                T -= 10;
                C++;
            }
        }
        System.out.println(-1);
    }
}
