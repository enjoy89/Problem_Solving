import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                case "pop" :
                    System.out.println(stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    System.out.println(stack.empty());
                    break;
                case "top" :
                    System.out.println(stack.top());
                    break;
                default:
                    System.out.println(-1);
                    break;
            }
        }

    }

    public static class Stack {
        private final List<Integer> stack;

        public Stack() {
            this.stack = new ArrayList<>();
        }

        public void push(int value) {
            stack.add(value);
        }

        public int pop() {
            if(stack.isEmpty()) return -1;
            return stack.remove(stack.size()-1);
        }

        public int size() {
            return stack.size();
        }

        public int empty() {
            return stack.isEmpty() ? 1 : 0;
        }

        public int top() {
            if(stack.isEmpty()) return -1;
            return stack.get(stack.size() - 1);
        }
    }
}


