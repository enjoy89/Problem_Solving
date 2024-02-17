import java.io.*;
import java.util.*;

public class N0207_점수계산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        if(arr[0] == 1) {
            total += 1;
        }
        int count = total;

        for(int i=1; i<N; i++) {
            if(arr[i] == 1) {
                count++;
                total += count;
            } else {
                count = 0;
            }
        }
        System.out.println(total);
    }
}
