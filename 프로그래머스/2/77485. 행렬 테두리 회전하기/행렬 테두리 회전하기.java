import java.util.*;

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] a = new int[rows+1][columns+1];
        
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                a[i][j] = (i-1) * columns + j;
            }
        }
        
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
        
            int prev = a[x1][y1];
            int min = prev;
            
            // 위쪽
            for(int y=y1+1; y<=y2; y++) {
                int tmp = a[x1][y];
                a[x1][y] = prev;
                prev = tmp;
                min = Math.min(min, prev);
            }
            
            // 오른쪽
            for(int x=x1+1; x<=x2; x++) {
                int tmp = a[x][y2];
                a[x][y2] = prev;
                prev = tmp;
                min = Math.min(min, prev);
            }
            
            // 아래쪽
            for(int y=y2-1; y>=y1; y--) {
                int tmp = a[x2][y];
                a[x2][y] = prev;
                prev = tmp;
                min = Math.min(min, prev);
            }
            
            // 왼쪽
            for(int x=x2-1; x>=x1; x--) {
                int tmp = a[x][y1];
                a[x][y1] = prev;
                prev = tmp;
                min = Math.min(min, prev);
            }

            answer[i] = min;
            
            // for(int s=1; s<=rows; s++) {
            //     System.out.println(Arrays.toString(a[s]));
            // }
            // System.out.println();
        }
        
        
        return answer;
    }
}