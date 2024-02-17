package 알고리즘_강의_문제풀이.part2_배열;

import java.io.*;
import java.util.*;

/**
 * 2024-02-17
 */
public class N0201_큰_수_출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(arr[0]+" ");

        for(int i=1; i<N; i++) {
            if(arr[i] > arr[i-1]) {
                sb.append(arr[i]+" ");
            }
        }

        System.out.println(sb);
    }
}
