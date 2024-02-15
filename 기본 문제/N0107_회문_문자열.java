import java.io.*;

/**
 * 2024-02-15
 */
public class N0107_회문_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
