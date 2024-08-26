import java.util.*;

public class Programmers_86971 {
    static int[][] graph;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        int answer = wires.length;


        for (int i = 0; i < wires.length; i++) {
            graph = new int[n + 1][n + 1]; // 그래프 초기화
            visited = new boolean[n + 1]; // 방문 여부 초기화

            // 송전탑 연결 정보 저장
            for (int j = 0; j < wires.length; j++) {
                // i번째 연결을 제외하고 저장
                if (wires[j] != wires[i]) {
                    graph[wires[j][0]][wires[j][1]] = 1;
                    graph[wires[j][1]][wires[j][0]] = 1;
                }
            }

            // 두 개의 출발지로 나누기
            int start1 = wires[i][0]; // 첫 번째 출발지
            int start2 = wires[i][1]; // 두 번째 출발지
            
            int sum1 = bfs(start1, n); // 첫 번째 송전탑 개수
            int sum2 = bfs(start2, n); // 두 번째 송전탑 개수

            if (answer > Math.abs(sum1 - sum2)) {
                answer = Math.abs(sum1 - sum2);
            }

            // sum1 - sum2 최소값 업데이트
        }
        return answer;
    }

    public static int bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true; // 방문 여부
        int count = 1; // 시작 송전탑 포함

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        System.out.println(solution(9, wires));
    }
}
