import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 문자열 비교. 첫 글자 기준으로 비교한다
        // 9가 10보다 큼
        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }
}