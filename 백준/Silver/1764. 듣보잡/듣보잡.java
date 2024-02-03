import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> str1 = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<N; i++) {
            str1.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String tmp = br.readLine();
            if(str1.contains(tmp)) {
                result.add(tmp);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String s : result) {
            System.out.println(s);
        }
    }
}
