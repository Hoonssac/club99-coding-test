import java.util.*;

class Programmers_76502 {

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 스택 생성
            Stack<Character> stack = new Stack<>();

            boolean correct = true;

            // 회전 중 현재 문자열
            String str = s.substring(i, s.length()) + s.substring(0, i);

            for (int j = 0; j < s.length(); j++) {
                char temp = str.charAt(j);
                switch (temp) {
                    case '(':
                        stack.push(temp);
                        break;
                    case '{':
                        stack.push(temp);
                        break;
                    case '[':
                        stack.push(temp);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            correct = false;
                            break;
                        }
                        else {
                            stack.pop();
                            break;
                        }
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            correct = false;
                            break;
                        }
                        else {
                            stack.pop();
                            break;
                        }
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            correct = false;
                            break;
                        }
                        else {
                            stack.pop();
                            break;
                        }
                }
            }

            if (stack.isEmpty() && correct == true) {
                answer++;
            }
            while (!stack.isEmpty()) {
                stack.pop();
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }
}