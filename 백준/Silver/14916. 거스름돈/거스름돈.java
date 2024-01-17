import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int total;

        if (n >= 5) {
            int count_5 = n / 5;
            int b = n % 5;

            if (b % 2 == 0) {
                int count_2 = b / 2;
                total = count_2 + count_5;
            } else {
                count_5 -= 1;
                b = n - (5 * count_5);
                int count2 = b / 2;
                total = count2 + count_5;
            }
        } else {
            if(n % 2 == 0) {
                total = n / 2;
            } else {
                total = -1;
            }

        }

        System.out.println(total);

    }
}