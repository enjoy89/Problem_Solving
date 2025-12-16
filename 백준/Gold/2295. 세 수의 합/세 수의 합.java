import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		// x + y
		Set<Integer> sum = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum.add(nums[i] + nums[j]);
			}
		}

		// x + y = k - z
		Arrays.sort(nums);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sum.contains(nums[j] - nums[i])) {
					answer = Math.max(answer, nums[j]);
				}
			}
		}

		System.out.println(answer);
	}

}
