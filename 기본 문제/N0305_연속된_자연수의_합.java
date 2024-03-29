import java.io.*;

/**
 * 2024-02-18
 * 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 구하라.
 */
public class N0305_연속된_자연수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = N/2+1; // 2개 이상의 연속된 자연수의 합이므로 N/2+1 만큼만 필요하다.
        int[] arr = new int[length+1];

        for(int i=1; i<=length; i++) {
            arr[i] = i;
        }

        int lt = 1, rt = 2;
        int count = 0;
        while(rt <= length) {
            int sum = 0;

            for(int i=lt; i<=rt; i++) {
                sum += arr[i];
            }

            if(sum == N) {
                count++;
                lt++;
            } else if(sum < N) {
                rt++;
            } else {
                lt++;
            }
        }

        System.out.println(count);
    }
}
