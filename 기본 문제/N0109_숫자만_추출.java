import java.io.*;

/**
 * 2024-02-15
 */
public class N0109_숫자만_추출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        str = str.replaceAll("[A-Z]", "");
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}
