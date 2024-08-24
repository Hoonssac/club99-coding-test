public class Programmers_43165 {

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public static int dfs(int[] numbers, int target, int index, int currSum) {
        // 모든 숫자를 조합한 경우
        if (index == numbers.length) {
            if (currSum == target) {
                return 1; // target과 일치할 경우
            }
            else {
                return 0; // target과 일치하지 않는 경우
            }
        }

        // 현재 숫자를 더하는 경우
        int add = dfs(numbers, target, index + 1, currSum + numbers[index]);

        // 현재 숫자를 빼는 경우
        int sub = dfs(numbers, target, index + 1, currSum - numbers[index]);

        return add + sub;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
