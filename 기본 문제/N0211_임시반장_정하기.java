import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 */
public class N0211_임시반장_정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N+1][6];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 학생과 같은 반이었던 학생이 있다면 카운팅
        // 반의 개수는 5로 고정이므로 시간 복잡도는 O(5N^2)이다.
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int n=1; n<=N; n++) {
            int[] curStudent = arr[n];
            int count = 0;

            for(int i=1; i<=N; i++) {
                // 자기 자신이면 넘어감
                if(n == i) {
                    continue;
                }
                // 현재 학생과 다른 학생이 같은 반이었던 횟수는, 학년과 상관 없이 최대 1회이다.
                for(int j=1; j<=5; j++) {
                    if(curStudent[j] == arr[i][j]) {
                        count++;
                        break;
                    }
                }
            }

            if(max < count) {
                max = count;
                result = n;
            }
        }
        System.out.println(result);
    }
}
