import java.io.*;
import java.util.*;

public class Main {

    static int[] operations = new int[4]; // +, -, *, /
    static int[] nums;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]); // 시작은 0번째 부터 시작, 다음 1번째 부터 시작
        System.out.println(max);
        System.out.println(min);

    }

    /**
     * 연산 재귀함수
     * 
     * @param index  다음에 사용할 숫자 인덱스
     * @param result 현재까지 누적 계산 결과
     */
    public static void dfs(int index, int result) {
        // 종료 조건
        if (index == N) {
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        int nextNum = nums[index];

        // 모든 선택지
        for (int op = 0; op < 4; op++) {
            if (operations[op] == 0) {
                continue;
            }

            // 선택
            operations[op]--;
            int nextResult;

            if (op == 0) {
                nextResult = result + nextNum;
            } else if (op == 1) {
                nextResult = result - nextNum;
            } else if (op == 2) {
                nextResult = result * nextNum;
            } else {
                nextResult = result / nextNum;
            }

            dfs(index + 1, nextResult); // 다음 상태
            operations[op]++; // 선택 복원
        }
    }
}
