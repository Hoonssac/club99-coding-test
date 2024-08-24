import java.util.*;

public class Programmers_169199 {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static char[][] map; // 게임판
    static boolean[][] visited; // 방문 여부
    static int[] start = new int[2]; // 시작점 좌표 정보

    public static int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>(); // bfs를 구현할 큐 생성

        // 게임판 저장
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                map[i][j] = board[i].charAt(j);

                // 시작점 저장
                if (map[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        queue.offer(start); // 시작점 입력
        visited[start[0]][start[1]] = true; // 시작점 방문 여부 표시

        int count = 0; // 이동 횟수

        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 현재 위치
                int[] current = queue.poll(); 
                for (int j = 0; j < 4; j++) {
                    // 현재 좌표
                    int curX = current[0];
                    int curY = current[1];

                    // 해당 방향으로 진행
                    while (curX + direction[j][0] >= 0 && curX + direction[j][0] < board.length &&
                    curY + direction[j][1] >= 0 && curY + direction[j][1] < board[0].length() &&
                    map[curX + direction[j][0]][curY + direction[j][1]] != 'D') {
                        curX = curX + direction[j][0]; // X좌표 이동
                        curY = curY + direction[j][1]; // Y좌표 이동
                    }
                    
                    // 목적지에 도착한 경우 count 리턴
                    if (map[curX][curY] == 'G') {
                        return count;
                    }

                    // 장애물에 막힌 경우
                    if (!visited[curX][curY]) {
                        queue.add(new int[] {curX, curY});
                        visited[curX][curY] = true;
                    }
                }
            } 

        }

        return -1;
    }

    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }
}
