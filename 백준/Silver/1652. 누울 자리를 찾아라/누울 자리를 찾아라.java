import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        int h_count = 0;
        int v_count = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                room[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            int tmp = 0;
            for(int j=0; j<N; j++) {
                if(room[i][j] == '.') {
                    tmp++;

                    if(tmp == 2) {
                        h_count++;
                    }
                } else {
                    tmp = 0;
                }
            }
        }
        sb.append(h_count).append(" ");


        for(int i=0; i<N; i++) {
            int tmp = 0;
            for(int j=0; j<N; j++) {
                if(room[j][i] == '.') {
                    tmp++;

                    if(tmp == 2) {
                        v_count++;
                    }
                } else {
                    tmp = 0;
                }
            }
        }
        sb.append(v_count);
        System.out.println(sb);

    }
}
