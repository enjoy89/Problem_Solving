import java.util.*;

class Solution {
     public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬하여 접두사 관계 문자열끼리 인접하게 위치함
        for(int i=0; i<phone_book.length-1; i++) {
            String cur = phone_book[i];
            String next = phone_book[i+1];
            if(next.startsWith(cur)) {
                return false;
            }
        }
        
        return true;
    }
}