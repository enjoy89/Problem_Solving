import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2024-02-15
 */
public class N0104_단어_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        for(int i=0; i<N; i++) {
//            String str = br.readLine();
////            String tmp = new StringBuilder(str).reverse().toString();
//            StringBuffer sb = new StringBuffer(str);
//            System.out.println(sb.reverse());
//        }

//        for(int i=0; i<N; i++) {
//            String str = br.readLine();
//            for(int j=str.length()-1; j>=0; j--) {
//                System.out.print(str.charAt(j));
//            }
//            System.out.println();
//        }

        // 왼쪽 인덱스와 오른쪽 인덱스를 구해서 서로 위치를 바꾼다.
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            int left = 0;
            int right = str.length()-1;
            char[] c = str.toCharArray();

            // 종료 조건: 왼쪽 인덱스가 오른쪽 인덱스보다 커지면 종료
            // 왼쪽 인덱스가 오른쪽 인덱스보다 커질 경우, 중간에서 만난 것이다.
            while(left < right) {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            }
            System.out.println(String.valueOf(c));
        }
    }
}
