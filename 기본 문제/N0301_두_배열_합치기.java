import java.io.*;
import java.util.*;

/**
 * 2024-02-18
 */
public class N0301_두_배열_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 번째 배열의 크기
        StringTokenizer st;
        int[] arr1, arr2;

        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 두 번째 배열의 크기
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 각각 정렬되어 있는 두 배열을 하나의 배열로 합쳐야 한다.
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        // 두 포인터가 각각의 배열의 길이만큼 도달하면 반복문을 멈추고, 남은 것들은 모두 리스트에 넣는다.
        while(p1 < N && p2 < M) {
            if(arr1[p1] > arr2[p2]) {
                result.add(arr2[p2]);
                p2++;
            } else if(arr1[p1] == arr2[p2]) {
                result.add(arr1[p1]);
                result.add(arr2[p2]);
                p1++;
                p2++;
            } else {
                result.add(arr1[p1]);
                p1++;
            }
        }

        if(N > M) {
            for(int i=p1; i<N; i++) {
                result.add(arr1[i]);
            }
        } else {
            for(int i=p2; i<M; i++) {
                result.add(arr2[i]);
            }
        }

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
