import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 가장 인접한 공유기 사이의 거리의 최대값을 구해야됨
        int left = 1; // 최소 거리
        int right = arr[arr.length-1] - arr[0]; // 가장 먼 거리
        int answer = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            // 일정 거리에서 설치 가능한 공유기의 수가 3개가 되는 것을 찾아야됨
            // 각 집끼리의 거리가 mid 이상이면 설치 가능
            int count = 1;
            int installed = arr[0]; // 처음 설치 위치
            for (int i = 1; i < N; i++) {
                if (arr[i] - installed >= mid) {
                    count++;
                    installed = arr[i];
                }
            }

            // 공유기 설치 개수가 C보다 같거나 클 때
            if(count >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }

}
