import java.io.*;
import java.util.*;

/**
 * 2024-02-20
 */
public class N0403_매출액의_종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // k개의 구간에서 각 매출액의 종류를 카운팅
        // 매출액의 중복을 체크해야된다.
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 매 구간마다 해시맵을 생성하고 모든 매출액을 다시 확인하는 부분에서 시간 초과 발생
        // 이 로직을 개선하기 위해서는 '슬라이딩 윈도우' 알고리즘을 사용해야 한다.
        // 슬라이딩 윈도우 알고리즘은
        // 구간을 이동할 때마다 새로 들어오는 요소와 빠져나가는 요소만을 확인하여 결과를 구할 수 있다.
//        int lt = 0;
//        while(lt + K <= N) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for(int i=lt; i<lt+K; i++) {
//                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//            }
//            result.add(map.size());
//            lt++;
//        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 초기 K일 동안의 매출액 종류를 구함
        for(int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        int lt = 0;
        for(int rt=K; rt<N; rt++) {
            // rt를 1씩 증가하며 새로운 매출액을 넣고,
            // 이전 매출액의 빈도수를 하나 줄여준다.
            // 만약 이전 매출액의 빈도수가 0이 된다면 map에서 제거한다.
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt], map.get(arr[lt]) - 1);

            if(map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            result.add(map.size());
            lt++;
        }

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
