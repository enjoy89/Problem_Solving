import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 * 각 학생이 멘토, 멘티로 짝을 지었을 때 모든 테스트에서 멘토가 멘티보다 앞 등수임을 체크한다.
 */
public class N0212_멘토링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 테스트 수
        int[][] arr = new int[M][N];
        boolean[][] students = new boolean[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {

                // 멘토와 멘티의 학생이 같은 경우는 스킵
                if(i == j) {
                    continue;
                }
                int count = 0;
                for(int t=0; t<M; t++) {
                    int[] test = arr[t];
                    int pi = 0, pj = 0;
                    for(int s=0; s<N; s++) {
                        if(test[s] == i) {
                            pi = s;
                        }
                        if(test[s] == j) {
                            pj = s;
                        }
                    }
                    if(pi < pj) {
                        count++;
                    }
                }
                if(count == M) {
                    students[i][j] = true;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(students[i][j] == true) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
