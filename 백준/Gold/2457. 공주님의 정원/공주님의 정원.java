import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] date = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				int day = changeTommdd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				date[i][j] = day;
			}
		}

		Arrays.sort(date, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 시작일이 같으면 종료일자 내림차순
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				// 시작일 오름차순
				return o1[0] - o2[0];
			}
		});

		int START_DATE = changeTommdd(3, 1);
		int END_DATE = changeTommdd(11, 30);
		int cur = START_DATE;
		int count = 0;
		int idx = 0;

		while (cur <= END_DATE) {
			int bestEnd = cur;

			// cur을 커버할 수 있는 구간을 돌면서 bestEnd 최대로 갱신
			while (idx < N && date[idx][0] <= cur) {
				bestEnd = Math.max(bestEnd, date[idx][1]);
				idx++;
			}

			// 해당 구간을 커버하지 못하면 공백이 생기므로 0 리턴
			if (bestEnd == cur) {
				System.out.println(0);
				return;
			}

			// 다음 구간으로 넘어감
			cur = bestEnd;
			count++;
		}

		System.out.println(count);

	}

	public static int changeTommdd(int month, int day) {
		return month * 100 + day;
	}
}
