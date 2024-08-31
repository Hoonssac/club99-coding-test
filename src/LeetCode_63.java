public class LeetCode_63 {


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // 세로 길이
        int n = obstacleGrid[0].length; // 가로 길이

        // 출발지 위치에 장애물이 있는 경우
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        // 0열 초기화
        for (int i = 1; i < m; i++) {
            // 장애물은 0으로 저장
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            }
            else {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }

        // 0행 초기화
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            }
            else {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
        }

        // 경로 수 탐색
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0; // 장애물 표시
                }
                else {
                    // 경로 수 업데이트
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }



    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }
}


