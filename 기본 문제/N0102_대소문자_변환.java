import java.util.*;

/**
 * 2024-02-15
 */
public class N0102_대소문자_변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            // 대문자인 경우에는 소문자로 변환
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));

            // 소문자인 경우에는 대문자로 변환
            } else if(Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);

    }
}
