public class Programmers_148653 {
    public static int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            System.out.println(storey);

            while (storey % 10 != 0) {
                if (storey % 10 > 5 || (storey % 10 == 5 && storey % 100 > 50)) {
                    storey++;
                    answer++;
                }
                else {
                    storey--;
                    answer++;
                }
            }
            System.out.println(storey);
            System.out.println(answer);

            if (storey != 1) {
                storey = storey / 10;
            }
            else {
                continue;
            }
        }
        
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(75));
    }
}
