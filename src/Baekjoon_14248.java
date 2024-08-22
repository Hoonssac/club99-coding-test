import java.util.*;

public class Baekjoon_14248 {
    public static int[] stones; // 돌다리 정보
    public static int count; // 돌 개수
    public static ArrayList<Integer> visited = new ArrayList<>(); // 돌 방문 여부

    // 점프 메서드
    public static void step(int start) {
        // start가 돌다리 범위 내에 있고, 방문하지 않은 경우에만 이동
        if (start > 0 && start <= count && !visited.contains(start)) {
            visited.add(start); // 방문한 돌 저장
            step(start - stones[start]); // 왼쪽 돌 방문
            step(start + stones[start]); // 오른쪽 돌 방문
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        stones = new int[count + 1];

        // 돌 정보 입력
        for (int i = 1; i <= count; i++) {
            stones[i] = sc.nextInt();
        }

        // 출발지 입력
        int start = sc.nextInt();

        // 점프
        step(start);

        // 방문한 돌 개수 출력
        System.out.println(visited.size());

        sc.close();
    }
    
}
