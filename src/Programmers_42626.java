import java.util.*;

class Programmers_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scvHeap = new PriorityQueue<>();
        int count = 0;
        
        for (int i = 0; i < scoville.length; i++) {
            scvHeap.add(scoville[i]);
        }
        
        while (!scvHeap.isEmpty() && scvHeap.peek() < K) {
            int a = scvHeap.poll();
            
            if (!scvHeap.isEmpty()) {
                int b = scvHeap.poll();
                scvHeap.add(a + b * 2);
                count++;
            }
            else {
                count = -1;
            }
        }
        return count;
    }
}