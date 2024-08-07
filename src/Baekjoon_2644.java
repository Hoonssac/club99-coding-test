import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_2644 {
    int[][] graph; // 관계도
    boolean[] visited; // 노드 방문 여부 저장
    int N; // 전체 인원

    public void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 전체 인원 입력
        sc.nextLine(); // 버퍼 비우기

        // 촌수를 확인할 서로 다른 두 사람 입력
        String[] Search = sc.nextLine().split(" ");
        int p1 = Integer.parseInt(Search[0]);
        int p2 = Integer.parseInt(Search[1]);

        int M = sc.nextInt(); // 관계 개수 입력
        sc.nextLine(); // 버퍼 비우기

        // graph, visitied 인스턴스 생성
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 관계 입력
        for (int i = 0; i < M; i++) {
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // p1에서부터 dfs 시작
        System.out.print(dfs(p1, p2, 0));
        sc.close();
    }

    public int dfs(int now, int dest, int chon) {
        if (now == dest) {
            return chon; // 찾을 두 사람이 같다면 chon 반환
        }

        visited[now] = true; // 현재 노드 방문 표기

        int r = -1; // 초기값 : -1

        for (int i = 1; i <= N; i++) {
            if (graph[now][i] == 1 && visited[i] == false) {
                int subR = dfs(i, dest, chon + 1); // 다음 노드 방문
                if (subR != -1 && subR >= r) { // 찾은 목적지까지의 촌수 업데이트
                    r = subR;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) throws IOException {
        Baekjoon_2644 baekjoon_2644 = new Baekjoon_2644();
        baekjoon_2644.solve();
    }
}
