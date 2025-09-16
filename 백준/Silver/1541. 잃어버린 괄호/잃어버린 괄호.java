import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("-");

        int result = 0;
        for(int i=0; i<parts.length; i++) {
            String[] nums = parts[i].split("\\+");
            int sum = 0;
            for(String num : nums) {
                sum += Integer.parseInt(num);
            }
            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
