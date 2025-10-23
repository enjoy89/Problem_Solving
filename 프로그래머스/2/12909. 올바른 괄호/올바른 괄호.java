import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') { // '('를 만나면 스택에 넣음
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}