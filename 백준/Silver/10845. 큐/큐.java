import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "push":
                    int value = Integer.parseInt(parts[1]);
                    queue.offer(value);
                    break;

                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
