import java.io.*;

/**
 * 2024-02-15
 */
public class N0111_문자열_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int index = 0;
        while(index < str.length()) {
            char c = str.charAt(index);
            int count = 0;

            for(int i=index; i<str.length(); i++) {
                if(str.charAt(i) == c) {
                    count++;
                } else {
                    break;
                }
                index++;
            }
            sb.append(c).append(count);
        }

        String result = sb.toString().replaceAll("1", "");
        System.out.println(result);
    }
}
