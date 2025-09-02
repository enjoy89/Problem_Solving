
import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int answer = -1;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        
        int h = maps.length;
        int w = maps[0].length;
        
        // 시작 위치
        int y = 0;
        int x = 0;
        
        visited[0][0] = true;
        q.offer(new int[]{y, x});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            if(cy == (h-1) && cx == (w-1)) {
                answer = maps[cy][cx];
            }
            
            for(int i=0; i<4; i++) {
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;
                
                if(ny>=0 && ny<h && nx>=0 && nx<w) {
                    
                    if(!visited[ny][nx] && maps[ny][nx] == 1) {
                        maps[ny][nx] = maps[cy][cx] + 1;
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    } 
                }
            }
         
        }
        
        return answer;
    }
}