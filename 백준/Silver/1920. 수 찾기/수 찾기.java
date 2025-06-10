import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for(int i=0; i<M; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int[] resultList = new int[M];
        for(int i=0; i<M; i++) {
            int result = 0; // 0으로 초기화. 존재하면 1, 존재하지 않으면 0
            int target = targets[i];

            int left = 0; // 0번째 인덱스
            int right = N-1; // 마지막 인덱스
            while(left <= right){
                int mid = (left+right)/2;
                if(target == A[mid]) {
                    result = 1;
                    break;
                }
                if(target >= A[mid]){
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            resultList[i] = result;
        }

        for(int result: resultList){
            System.out.println(result);
        }
    }
}
