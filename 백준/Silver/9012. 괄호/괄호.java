import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char c : str.toCharArray()) {
                if ('(' == c) {
                    stack.push('(');
                } else {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }

            }
            if(isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}