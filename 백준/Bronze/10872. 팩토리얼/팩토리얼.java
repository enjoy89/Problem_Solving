
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(recursive(N));

    }

    public static int recursive(int n) {
        if(n <= 0) {
            return 1;
        } else {
            return n * recursive(n-1);
        }
    }
}
