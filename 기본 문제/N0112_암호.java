import java.io.*;

/**
 * 2024-02-15
 */
public class N0112_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int part = 0;
        for(int i=0; i<N; i++) {
            int start = 7 * part;
            String code = str.substring(start, start + 7);
            String tmp = "";

            for(int j=0; j<7; j++) {
                if(code.charAt(j) == '#') {
                    tmp += "1";
                } else if(code.charAt(j) == '*') {
                    tmp += "0";
                }
            }
            part++;

            int c = Integer.parseInt(tmp, 2);
            System.out.print((char) c);

        }
    }
}
