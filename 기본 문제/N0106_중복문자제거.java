import java.io.*;

/**
 * 2024-02-15
 */
public class N0106_중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        // indexOf(): 문자열 앞에서부터 특정 문자가 처음 발견되는 인덱스를 반환한다.
        // 현재 문자의 실제 인덱스 번호와, indexOf의 인덱스가 같은 경우에만 중복이 아니다.
        for(int i=0; i<str.length(); i++) {
            int index = str.indexOf(str.charAt(i));
            if(index == i) {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
