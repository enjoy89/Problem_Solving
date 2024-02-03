import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tag = false;

        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                tag = true;

            } else if(c == '>') {
                tag = false;
                sb.append(c);
                continue;
            }

            if(tag) {
                sb.append(c);
            } else {
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }

            if(i == str.length() - 1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}
