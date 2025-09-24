import java.io.*;
import java.util.*;

public class Main {
    static int[] T, P;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1]; // 상담 시간
        P = new int[N+1]; // 금액

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int sum) {
        // 종료조건: N일 이상인 경우
        if(index >= N+1) {
            answer = Math.max(answer, sum);
            return;
        }

        // 상담 가능한 경우
        if(index + T[index] <= N+1) {
            dfs(index + T[index], sum + P[index]);
        }
        dfs(index+1, sum);
    }
}
