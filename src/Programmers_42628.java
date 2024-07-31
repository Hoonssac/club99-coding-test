import java.util.*;

class Programmers_42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // 최소 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 최대 힙 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            // 공백을 기준으로 분리
            String[] temp = operation.split(" ");
            
            // 명령이 "I"인 경우 각각의 우선순위 큐에 추가
            if (temp[0].equals("I")) {
                minHeap.add(Integer.parseInt(temp[1]));
                maxHeap.add(Integer.parseInt(temp[1]));
            }
            
            else if (!maxHeap.isEmpty() && temp[0].equals("D") && temp[1].equals("1")) {
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
            else if (!minHeap.isEmpty() && temp[0].equals("D") && temp[1].equals("-1")) {
                int min = minHeap.poll();
                maxHeap.remove(min);
            }
        }
        
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        
        else {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}