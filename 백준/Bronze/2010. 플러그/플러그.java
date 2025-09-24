import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] multitap = new Integer[N];

        for(int i=0; i<N; i++) {
            multitap[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(multitap, Collections.reverseOrder());
        int answer = multitap[0]; // 가장 많은 플러그를 가진 멀티탭
        for(int i=1; i<N; i++) {
            answer += multitap[i]-1;
        }
        System.out.println(answer);
    }
}
