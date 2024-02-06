import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        // 첫 번째 문자 비교를 위해 길이는 +1
        int[][] tmp = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i< tmp.length; i++) {
            for(int j=1; j<tmp[1].length; j++) {
                int s1_index = i-1;
                int s2_index = j-1;
                
                // 문자가 같다면 왼쪽 대각선 위 값에서 1을 더한다.
                if(s1.charAt(s1_index) == s2.charAt(s2_index)) {
                    tmp[i][j] = tmp[i-1][j-1] + 1;
                }
                // 문자가 다르다면 왼쪽 값과 바로 위쪽 값 중 더 큰 값을 가져온다.
                else {
                    tmp[i][j] = Math.max(tmp[i-1][j], tmp[i][j-1]);
                }
            }
        }
        int result = 0;

        for(int i : tmp[tmp.length-1]) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}
