import java.util.*;

public class Programmers_1844 {
    static boolean[][] visited; // 방문 여부
    static int nLen; // 가로 길이
    static int mLen; // 세로 길이
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

    public static int solution(int[][] maps) {
        nLen = maps[0].length; // 가로 길이 (열)
        mLen = maps.length; // 세로 길이 (행)
        visited = new boolean[mLen][nLen]; // 방문 여부 배열 생성

        return bfs(0, 0, maps);
    }
    
    public static int bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 1}); // 시작점과 거리 1 저장
        visited[x][y] = true; // 시작점 방문 여부 저장

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치
            int curX = current[0];
            int curY = current[1];
            int distance = current[2];

            // 도착점에 도달한 경우
            if (curX == mLen - 1 && curY == nLen - 1) {
                return distance; // 최단 거리 반환
            }

            for (int i = 0; i < 4; i++) {
                int newX = curX + step[i][0];
                int newY = curY + step[i][1];

                // 유효한 위치인지 확인
                if (newX >= 0 && newX < mLen && newY >= 0 && newY < nLen) {
                    // 이동할 수 있는 위치이면서 아직 방문하지 않은 경우
                    if (maps[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true; // 방문 처리
                        queue.offer(new int[] {newX, newY, distance + 1}); // 거리 업데이트
                    }
                }
            }
        }
        return -1; // 목적지에 도착할 수 없는 경우

    }


    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
