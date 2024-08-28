import java.util.*;

public class Programmers_142085 {
    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        if (k >= enemy.length) {
            return enemy.length;
        }
        
        // 초반에 무적권 다 사용
        for (int i = 0; i < k; i++) {
            pq.add(enemy[i]); // 무적권 사용
            answer++; // 막아낸 라운드 증가
        }

        for (int i = k; i < enemy.length; i++) {
            if (pq.peek() < enemy[i] && pq.peek() <= n) {
                n -= pq.poll(); // 남은 병사로 막아내기
                pq.add(enemy[i]); // i번째 라운드에 대한 무적권 사용
                answer++; // 막아낸 라운드 개수 증가
            }
            else {
                if (enemy[i] > n) {
                    return answer; // 더 이상 진행 불가
                }
                else {
                    n -= enemy[i]; // 남은 병사 수 업데이트
                    answer++; // 막아낸 라운드 개수 증가
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] enemy = {12, 11, 4, 2, 1, 5, 8, 6, 7};
        int n = 10;
        int k = 3;
        System.out.println(solution(n, k, enemy));
    }
}
