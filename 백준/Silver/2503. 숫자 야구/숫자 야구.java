import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Number> game;

    public static class Number {
        String num;
        int strike;
        int ball;

        public Number(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        game = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String n = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            game.add(new Number(n, s, b));
        }

        int result = 0;
        for (int i = 123; i <= 987; i++) {
            if (checkNum(i)) {
                String currNum = Integer.toString(i);
                int strikeCount = 0;
                int ballCount = 0;
                int pass = 0;

                for(int j=0; j<N; j++) {
                    Number number = game.get(j);
                    String inputNumber = number.num;
                    strikeCount = isStrike(currNum, inputNumber);
                    ballCount = isBall(currNum, inputNumber);

                    if(strikeCount == number.strike && ballCount == number.ball) {
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

    public static int isBall(String currNum, String inputNum) {
        int ball =0;
        for(int i=0; i<3; i++) {
            if(currNum.charAt(i) == inputNum.charAt((i+1) % 3) ||
            currNum.charAt(i) == inputNum.charAt((i+2) % 3)) {
                ball++;
            }
        }
        return ball;

    }
    public static int isStrike(String currNum, String inputNum) {
        int strike = 0;
        for(int i=0; i<3; i++) {
            if(currNum.charAt(i) == inputNum.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    // 중복이거나 0인지 체크
    public static boolean checkNum(int num) {
        String numStr = Integer.toString(num);

        if (numStr.charAt(0) == numStr.charAt(1) || numStr.charAt(0) == numStr.charAt(2)
                || numStr.charAt(1) == numStr.charAt(2)) {
            return false;
        }

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}
