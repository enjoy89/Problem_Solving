import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        int[] person_1 = {1, 2, 3, 4, 5};                   
        int[] person_2 = {2, 1, 2, 3, 2, 4, 2, 5};     
        int[] person_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    

        int[] corrects = new int[3];  

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person_1[i % person_1.length]) {
                corrects[0]++;
            }
            if (answers[i] == person_2[i % person_2.length]) {
                corrects[1]++;
            }
            if (answers[i] == person_3[i % person_3.length]) {
                corrects[2]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = Arrays.stream(corrects).max().getAsInt();

        for (int i = 0; i < corrects.length; i++) {
            if (corrects[i] == max) {
                list.add(i + 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}