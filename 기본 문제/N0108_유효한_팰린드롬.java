import java.io.*;

/**
 * 2024-02-15
 */
public class N0108_유효한_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // A부터 Z까지의 문자가 아니면 ""으로 바꾼다.
        // 특수 문자를 모두 제거
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if(str.equals(tmp)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
