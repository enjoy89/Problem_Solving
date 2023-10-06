import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> players_rank = new HashMap<>();    
        Map<Integer, String> players_name = new HashMap<>();  

        for (int i = 0; i < players.length; i++) {
            players_rank.put(players[i], i);
            players_name.put(i, players[i]);
        }

        for (String calling : callings) {
            int currRank = players_rank.get(calling);        
            String currPlayer = players_name.get(currRank);         
            String frontPlayer = players_name.get(currRank - 1);    

            // swqp 처리
            players_name.put(currRank - 1, currPlayer);
            players_name.put(currRank, frontPlayer);

            players_rank.put(currPlayer, currRank - 1);
            players_rank.put(frontPlayer, currRank);

        }

        for (int i = 0; i < players.length; i++) {
            players[i] = players_name.get(i);
        }

        return players;
    }
}