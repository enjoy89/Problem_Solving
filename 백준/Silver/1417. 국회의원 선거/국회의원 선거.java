import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        for(int i=0; i<N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int dasom = people[0];

        while(true) {
            int dif = -1;
            int index = 0;
            for(int i=1; i<N; i++) {
                if(dif < people[i] - dasom) {
                    dif = people[i] - dasom;
                    index = i;
                }
            }
            if(dif <= -1) {
                System.out.println(count);
                break;
            }

            dasom += 1;
            people[index] -= 1;
            count++;
        }
    }
}
