import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        Arrays.sort(meetings, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0]; // 종료 시간이 같으면 시작 시간으로 오름차순
            } else {
                return a[1] - b[1]; // 종료 시간으로 오름차순
            }
        });

        int count = 0;
        int end = 0; // 직전 회의의 종료 시간

        for(int i=0; i<N; i++) {
            if(meetings[i][0] >= end) {
                end = meetings[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
