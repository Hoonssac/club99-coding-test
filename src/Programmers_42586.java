import java.util.*;

class Programmers_42586 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int releaseIndex = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        
        while (releaseIndex < progresses.length) {
            for (int j = 0; j < progresses.length; j++) {
                progresses[j] += speeds[j];
            }
            int count = 0;
            while (releaseIndex < progresses.length && progresses[releaseIndex] >= 100) {
                releaseIndex++;
                count ++;
            }
            if (count > 0) {
                answer.add(count);
            }
        }
        return answer;
    }
}
