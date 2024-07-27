import java.util.*;

class Programmers_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesCount = new HashMap<>();
        for (String[] cloth : clothes) {
            clothesCount.put(cloth[1], clothesCount.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int value : clothesCount.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
        
    }
}