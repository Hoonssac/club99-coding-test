
import java.util.*;

public class Programmers_178871 {
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> ranking = new HashMap<>();

        // 초기 순위 데이터 저장
        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String called : callings) {
            // 이름이 불린 선수 인덱스 추출
            int calledRank = ranking.get(called);

            // players 배열에서 순위 변경
            String catched = players[calledRank - 1];
            players[calledRank - 1] = players[calledRank];
            players[calledRank] = catched;

            // HashMap 순위 업데이트
            ranking.put(catched, ranking.get(catched) + 1);
            ranking.put(called, ranking.get(called) - 1);


        }

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution(players, callings);
    }
}
