public class Programmers_42883 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int startIdx = 0;
        int answerLength = number.length() - k;
        
        for (int i = 0; i < answerLength; i++) {
            int max = 0;
            for (int j = startIdx; j <= i + k; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    startIdx = j + 1;
                }
            }
            answer.append(Integer.toString(max));
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
}
