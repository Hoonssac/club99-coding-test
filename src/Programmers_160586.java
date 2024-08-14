
import java.util.Arrays;

public class Programmers_160586 {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (char c : target.toCharArray()) {
                int minIndex = 100;
                for (String key : keymap) {
                    int index = key.indexOf(c);
                    if (index != -1 && index < minIndex) {
                        minIndex = index;
                    }
                }
                if (minIndex < 100 && answer[i] != -1) {
                    answer[i] += minIndex + 1;
                }
                else {
                    answer[i] = -1;
                }

            }

            
        }
        

        return answer;
    }
    public static void main(String[] args) {
        String[] keymep = {"AA"};
        String[] targets = {"B"};

        System.out.println(Arrays.toString(solution(keymep, targets)));
    }
}
