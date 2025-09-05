import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N+1];
        dfs(0);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true; // 방문 처리
                arr[depth] = i; // 수열에 숫자 저장
                dfs(depth + 1); // 다음 깊이로
                visited[i] = false; // 방문 처리 초기화 (백트래킹)
            }
        }
    }
}
