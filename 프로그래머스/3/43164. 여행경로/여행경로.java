import java.util.*;

class Solution {
    static boolean[] used;
    static List<String> answer;
    static boolean found;
    
    public String[] solution(String[][] tickets) {
        // 사전순 정렬
        // 출발지가 같으면 도착지 기준으로 정렬
        Arrays.sort(tickets, (a, b) ->
                   a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0])
                   );
        
        used = new boolean[tickets.length];
        answer = new ArrayList<>();
        found = false;
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path, tickets);  
        return answer.toArray(new String[0]);
    }
    
    public static void dfs(String start, List<String> path, String[][] tickets) {
        // 종료조건: 항공권 모두 사용
        if(path.size() == tickets.length+1) {
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!used[i] && start.equals(tickets[i][0])) {
                used[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], path, tickets);
                
                if(found) {
                    return;
                }
                
                path.remove(path.size()-1);
                used[i] = false;
            } 
        }
    }
}