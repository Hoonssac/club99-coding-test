public class LeetCode_62 {

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        // 그리드 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
