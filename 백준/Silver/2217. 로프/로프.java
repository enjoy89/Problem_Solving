import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums, Collections.reverseOrder());

        int result = 0;
        for(int i=0; i<N; i++) {
            int weight = nums[i] * (i + 1);
            result = Math.max(result, weight);
        }
        System.out.println(result);
    }
}
