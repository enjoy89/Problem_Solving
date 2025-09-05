import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int[] numbers;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);

    }

    public static void dfs(int index, int sum, int count) {
        if (index == N) {
            if (sum == S && count > 0) {
                answer++;
            }
            return;
        }

        // 현재 숫자를 선택하는 경우
        dfs(index + 1, sum + numbers[index], count + 1);

        // 현재 숫자를 선택하지 않는 경우
        dfs(index + 1, sum, count);
    }
}
