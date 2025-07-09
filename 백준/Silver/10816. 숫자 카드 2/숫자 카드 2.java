import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] myCard = new int[N]; // 상근이가 가지고 있는 카드
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            myCard[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] card = new int[M]; // 탐색할 카드
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCard); // 이진 탐색을 위한 정렬

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<M; i++) {
            int target = card[i];
            answer.append(upperBound(myCard, target) - lowerBound(myCard, target)).append(" ");
        }
        System.out.println(answer);
    }

    /**
     * 하한 탐색
     * target 이상인 값이 처음 등장하는 인덱스 반환
     * 삽입 가능한 위치 == target 값의 첫 등장 위치
     */
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length; // 배열의 끝도 target 값의 삽입 위치가 될 수 있으므로 포함시킴
        // left와 right가 같아질 때까지 반복
        while(left < right) {
            int mid = (left + right) / 2;
            if(target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 상하 탐색
     * target 값을 초과하는 값이 처음 등장하는 인덱스 반환
     * 삽입 가능한 위치 == target 값의 마지막 등장 다음 위치
     */
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
