import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2024-02-15
 */
public class N0103_문장_속_단어 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int maxCount = 0;
//
//        for(int i=0; i<str.length; i++) {
//            int length = str[i].length();
//
//            if(length > maxCount) {
//                maxCount = length;
//            }
//        }
//
//        for(String s : str) {
//            if(s.length() == maxCount) {
//                System.out.println(s);
//                break;
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";

        int maxCount = 0;
        int pos;

        // 문자열 앞에서부터 공백이 발견되는 인덱스가 없을 때
        // 문자열의 끝까지 탐색한다는 의미
        // 하지만 마지막 문자의 경우 다음 문자에 공백이 없으므로 예외 처리 해줘야 한다.
        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos); // 하나의 단어
            int length = tmp.length();

            if(length > maxCount) {
                maxCount = length;
                answer = tmp;
            }

            str = str.substring(pos+1);
        }

        if(str.length() > maxCount) {
            answer = str;
        }

        System.out.println(answer);

    }
}
