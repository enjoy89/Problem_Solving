
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class BaseballGame {
        String number;
        int strike;
        int ball;

        public BaseballGame(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static ArrayList<BaseballGame> info = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info.add(new BaseballGame(n, s, b));
        }

        for (int i = 123; i <= 987; i++) {
            int pass = 0;
            if (check(i)) {
                String possibleNum = Integer.toString(i);

                for (int j = 0; j < N; j++) {
                    BaseballGame baseballGame = info.get(j);
                    String inputNum = baseballGame.number;
                    int strikeCount = isStrike(possibleNum, inputNum);
                    int ballCount = isBall(possibleNum, inputNum);

                    if(strikeCount == baseballGame.strike && ballCount == baseballGame.ball) {
                        pass++;
                    } else {
                        break;
                    }
                }
                if(pass == N) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean check(int n) {
        String ns = Integer.toString(n);

        if (ns.contains("0")) {
            return false;
        }
        if (ns.charAt(0) == ns.charAt(1) || ns.charAt(0) == ns.charAt(2) || ns.charAt(1) == ns.charAt(2)) {
            return false;
        }
        return true;
    }

    public static int isStrike(String possibleNum, String inputNum) {
        int sc = 0;
        for (int i = 0; i < 3; i++) {
            if (possibleNum.charAt(i) == inputNum.charAt(i)) {
                sc++;
            }
        }
        return sc;
    }

    public static int isBall(String possibleNum, String inputNum) {
        int bc = 0;
        for (int i = 0; i < 3; i++) {
            if((possibleNum.charAt(i) != inputNum.charAt(i)) && (possibleNum.indexOf(inputNum.charAt(i)) != -1)) {
                bc++;
            }
        }
        return bc;
    }
}
