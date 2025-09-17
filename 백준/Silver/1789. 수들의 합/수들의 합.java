import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int count = 0;
        int i =1;

        while(true) {
            if(sum + i > S) {
                break;
            }
            sum += i;
            i++;
            count++;
        }
        System.out.println(count);
    }
}
