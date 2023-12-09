import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int TOTAL = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int difference = sum - TOTAL;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int n1 = arr[i];
                int n2 = arr[j];

                if (n1 + n2 == difference) {
                    list.add(n1);
                    list.add(n2);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] != list.get(0) && arr[i] != list.get(1)) {
                System.out.println(arr[i]);
            }
        }
    }
}