import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        check = false;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 0);

            if(check) {
                break;
            }
        }

        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == 4) {
            check = true;
            return;
        }
        if (visited[v]) {
            return;
        }
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[v] = false;
    }
}