import java.util.*;

class Programmers_159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cards1Index = 0;
        int cards2Index = 0;
        int goalIndex = 0;
        
        for (goalIndex = 0; goalIndex < goal.length; goalIndex++) {
            
            // 카드1에 들어 있다면
            if (cards1Index < cards1.length && goal[goalIndex].equals(cards1[cards1Index])) {
                cards1Index++;
            }
            
            // 카드2에 들어 있다면
            else if (cards2Index < cards2.length && goal[goalIndex].equals(cards2[cards2Index])) {
                cards2Index++;
            }
            else {
                answer = "No";
            }
        }
        
        return answer;
    }
}