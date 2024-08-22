import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_154540 {
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부
    static int dayCount; // 해당 땅에서의 생존 일수
    static int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 이동
    static int sizeRow; // 지도 가로 크기
    static int sizeCol; // 지도 세로 크기

    public static int[] solution(String[] maps) {
        int[] answer;
        sizeRow = maps[0].length();
        sizeCol = maps.length;
        map = new int[sizeCol][sizeRow];
        visited = new boolean[sizeCol][sizeRow];
        ArrayList<Integer> days = new ArrayList<>(); // 무인도에서의 총 생존 일수

        // 지도 정보 입력
        for (int i = 0; i < sizeCol; i++) {
            String temp = maps[i];
            for (int j = 0; j < sizeRow; j++) {
                if (temp.charAt(j) == 'X') {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
                }
            }
        }


        for (int i = 0; i < sizeCol; i++) {
            for (int j = 0; j < sizeRow; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dayCount = 0;
                    dfs(i, j); // dfs 호출
                    days.add(dayCount); // 총 생존 일수 저장
                }
            }
        }

        // 찾은 무인도가 없다면 -1 저장
        if (days.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        // 찾은 무인도가 있다면 오름차순으로 생존 일수 저장
        else {
            answer = new int[days.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = days.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }

    public static void dfs(int a, int b) {
        visited[a][b] = true; // 방문 여부 표시
        dayCount += map[a][b]; // 생존 일수 증가

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            // 이동한 좌표 갱신
            int newX = a + step[i][0];
            int newY = b + step[i][1];

            // 이동한 좌표가 지도 안에 있고, 땅이 이어져 있고, 아직 방문하지 않은 곳이라면
            if (newX >= 0 && newX < sizeCol && newY >= 0 && newY < sizeRow && map[newX][newY] != 0 && !visited[newX][newY]) {
                dfs(newX, newY); // 해당 좌표로 이동
            }
        }

        
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
}
