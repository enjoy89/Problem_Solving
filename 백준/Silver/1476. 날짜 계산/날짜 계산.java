import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int curE = 1;
        int curS = 1;
        int curM = 1;
        int answer = 1;
        
        while (true) {
            if (curE > 15) {
                curE = 1;
            }
            if (curS > 28) {
                curS = 1;
            }
            if (curM > 19) {
                curM = 1;
            }

            if (curE == E && curS == S && curM == M) {
                break;
            }

            curE++;
            curS++;
            curM++;
            answer++;
        }
        System.out.println(answer);
    }
}
