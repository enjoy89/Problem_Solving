import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            cnt[num]++;
        }

        int answer = 0;
        int tmp = (cnt[6] + cnt[9]+1) / 2; // 6,9가 필요한 총 개수

        // 각 숫자가 필요한 개수 중에서 최대값이 세트 개수가 된다.
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            answer = Math.max(answer, cnt[i]);
        }

        // 가장 많이 필요한 세트 개수를 구함
        answer = Math.max(answer, tmp);
        System.out.println(answer);
    }
}
