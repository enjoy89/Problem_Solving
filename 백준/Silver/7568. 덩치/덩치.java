import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x
            arr[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            int person = i;
            int x = arr[i][0];
            int y = arr[i][1];

            for (int j = 0; j < N; j++) {
                if (x < arr[j][0] && y < arr[j][1]) {
                    rank++;
                }
                ranks[person] = rank;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}