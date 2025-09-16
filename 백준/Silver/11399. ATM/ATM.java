import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //사람의 수
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);
        int answer = 0;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += times[j];
            }
            answer += sum;
        }
        System.out.println(answer);
    }
}
