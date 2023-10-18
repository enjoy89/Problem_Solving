class Solution {
    public int solution(int[][] sizes) {

        for (int i = 0; i < sizes.length; i++) {
            int temp;
            if (sizes[i][0] < sizes[i][1]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int horizontal_max = sizes[0][0];
        int vertical_max = sizes[0][1];

        for (int[] size : sizes) {
            if (horizontal_max < size[0]) {
                horizontal_max = size[0];
            }
            if (vertical_max < size[1]) {
                vertical_max = size[1];
            }
        }
        return horizontal_max * vertical_max;
    }
}