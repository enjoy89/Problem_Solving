import java.io.*;

/**
 * 2024-02-15
 */
public class N0105_특정_문자_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] c = str.toCharArray();
        int left = 0;
        int right = str.length()-1;

        while(left < right) {
            // 특수문자인 경우에는 그냥 넘어간다.
            if(!Character.isAlphabetic(c[left])) {
                left++;
            } else if(!Character.isAlphabetic(c[right])) {
                right--;
            // 둘 다 특수문자가 아니고, 일반 알파벳인 경우에만 자리 위치 교환
            } else {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            }
        }

        System.out.println(String.valueOf(c));
    }
}
