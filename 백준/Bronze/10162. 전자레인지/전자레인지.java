import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int A = 0; // 300
        int B = 0; // 60
        int C = 0; // 10

        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }

        A += T / 300;
        T %= 300;

        B += T / 60;
        T %= 60;

        C += T / 10;
        T %= 10;

        System.out.println(A + " " + B + " " + C);
    }
}
