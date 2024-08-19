public class LeetCode_300 {
    public static int lengthOfLIS(int[] nums) {
        int answer = 1;

         // dp 배열 생성
        int[] dp = new int[nums.length];

        // dp 배열 초기화
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i : dp) {
            answer = Math.max(answer, i);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
