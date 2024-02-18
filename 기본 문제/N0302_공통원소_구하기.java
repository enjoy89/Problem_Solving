import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 */
public class N0302_공통원소_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr1, arr2;

        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < N && p2 < M) {
            if(arr1[p1] == arr2[p2]) {
                result.add(arr1[p1]);
                p1++;
                p2++;
            } else if(arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
