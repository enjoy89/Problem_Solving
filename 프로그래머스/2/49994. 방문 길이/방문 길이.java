import java.util.*;

class Solution {   
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        int answer = 0;
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for(char c : dirs.toCharArray()) {
            int nx = x, ny = y;
            if(c == 'U') {
                nx = x + dx[0];
                ny = y + dy[0];
            } else if(c == 'D') {
                nx = x + dx[1];
                ny = y + dy[1];
            } else if(c == 'L') {
                nx = x + dx[2];
                ny = y + dy[2];
            } else if(c == 'R') {
                nx = x + dx[3];
                ny = y + dy[3];
            }
            
            if(ny >= -5 && ny <=5 && nx >= -5 && nx <= 5) {
                String path1 = x + "," + y + "->" + nx + "," + ny;
                String path2 = nx + "," + ny + "->" + x + "," + y;
                System.out.println(path1);
                System.out.println(path2);
                if(!visited.contains(path1)) {
                    visited.add(path1);
                    visited.add(path2);
                    answer++;
                }
                
                x = nx;
                y = ny;
            }
            
        }
       
        return answer;
    }
    
}