import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        String[] words = set.toArray(new String[0]);

        Arrays.sort(words, (a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length(); // 길이가 다르면 짧은 것부터
            } else {
                return a.compareTo(b); // 길이가 같으면 사전순으로
            }
        });

        for(String s : words) {
            System.out.println(s);
        }
    }
}
