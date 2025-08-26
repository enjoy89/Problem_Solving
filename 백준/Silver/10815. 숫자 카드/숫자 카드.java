import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int target =  targets[i];
            int left = 0;
            int right = nums.length-1;
            int answer = 0;

            while(left <= right) {
                int mid = (left+right)/2;
                if(nums[mid] == target) {
                    answer = 1;
                    break;
                }

                if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}
