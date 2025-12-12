import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        int count = 0;
        int prev_end_time = 0;
        for(int i=0; i<N; i++) {
            // 이전 회의 종료 시간이 다음 회의 시작 시간 보다 작거나 같으면 갱신
            int next_start_time = time[i][0];
            if(prev_end_time <= next_start_time) {
                count++;
                prev_end_time = time[i][1];
            }
        }
        
        System.out.println(count);
    }
}