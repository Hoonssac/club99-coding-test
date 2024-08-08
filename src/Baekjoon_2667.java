import java.util.ArrayList;
import java.util.Scanner;
import static java.util.Collections.sort;

public class Baekjoon_2667 {
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부를 담고 있는 배열
    static int size; // 지도의 크기
    static int count;
    static int[][] see = {{-1, 0},{1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        sc.nextLine();
        map = new int[size][size]; // 지도 생성
        visited = new boolean[size][size]; // 방문 여부
        ArrayList<Integer> result = new ArrayList<>();

        // 배열 입력받기
        for (int i = 0; i < size; i++) {
            String[] input = sc.nextLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 단지 찾기
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                // 집이 존재하고 방문하지 않았을 경우
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j); // dfs 호출
                    result.add(count); // 단지 수 저장
                }
            }
        }

        System.out.println(result.size());
        sort(result);
        for (int integer : result) {
            System.out.println(integer);
        }
    }

    // DFS
    static void dfs(int x, int y) {
        count++; // 단지 수 증가
        visited[x][y] = true;

        // 상하좌우 탐색
        for (int i = 0; i < see.length; i++) {
            // 상하좌우 이동한 좌표
            int newX = x + see[i][0];
            int newY = y + see[i][1];

            // 이동한 좌표가 map 안에 있고, 이동한 좌표에 집이 있고, 방문하지 않았을 때
            if (newX >= 0 && newX < size && newY >= 0 && newY < size && map[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
}
