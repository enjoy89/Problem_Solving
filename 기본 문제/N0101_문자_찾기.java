import java.util.Scanner;

/**
 * 2024-02-15
 */
public class N0101_문자_찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        int answer = 0;

        // 소문자를 대문자로 변환: toUpperCase()
        // 대문자를 소문자로 변환: toLowerCase()
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                answer++;
            }
        }

        // 문자열 배열을 문자형 배열로 변환
        for(char x : str.toCharArray()) {
            if(x == c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
