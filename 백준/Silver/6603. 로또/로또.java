import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int[] nums;
    static int[] result = new int[6]; // 선택된 6개 숫자를 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int count) {
        if (count == 6) {
            for (int i = 0; i < count; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            result[count] = nums[i];
            dfs(i + 1, count + 1);

        }

    }

}
