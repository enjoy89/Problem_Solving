import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) {
                plus.add(num);
            } else if(num == 1) {
                ones++;
            } else if(num == 0) {
                zeros++;
            } else {
                minus.add(num);
            }
        }
        
        // 양수는 내림차순 정렬
        Collections.sort(plus, Collections.reverseOrder());
        // 음수는 오름차순 정렬
        Collections.sort(minus);

        int result = 0;
        for(int i=0; i<plus.size(); i+=2) {
            if(i+1 < plus.size()) {
                result += plus.get(i) * plus.get(i+1);
            } else {
                result += plus.get(i); // 남는 수는 그냥 덧셈
            }
        }

        for(int i=0; i<minus.size(); i+=2) {
            if(i+1 < minus.size()) {
                result += minus.get(i) * minus.get(i+1);
            } else {
                if(zeros > 0) { // 음수가 하나 남으면 0이랑 곱해버림
                    zeros--;
                } else { // 0이 없으면 그냥 덧셈
                    result += minus.get(i);
                }
            }
        }

        result += ones;
        System.out.println(result);
    }
}
