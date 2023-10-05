class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int common_difference;
        int common_ratio;

        if((common[1] - common[0]) == (common[2] - common[1])) {
            common_difference = common[1] - common[0];
            answer = common[common.length - 1] + common_difference;
        } else {
            common_ratio = common[1] / common[0];
            answer = common[common.length - 1] * common_ratio;
        }
        return answer;
    }
}