import java.util.*;

public class Baekjoon_2529 {
    static boolean[] visited = new boolean[10]; // 방문 여부
    static String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; // 사용 가능한 숫자
    static int count; // 입력받을 부등호 개수
    static String[] input; // 입력받을 부등호
    static ArrayList<String> result = new ArrayList<>(); // 결과 리스트

    // permutation(int index, String res) 메서드는 현재까지 선택한 숫자의 개수를 나타내는 index와
    // 현재까지 선택한 숫자를 문자열로 저장하는 now를 매개변수로 받습니다.
    static void permutation(int index, String now) {
        // 순열을 다 만들었을 경우
        // 현재까지 만든 숫자 조합 now가 부등호 조건을 만족하는 지 확인
        if (index == count + 1) {
            // 부등호 조건을 만족한다면 결과 리스트에 추가
            if (check(now)) {
                result.add(now);
            }
            return;
        }

        // 순열 만들기
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, now + num[i]);
                visited[i] = false;
            }
        }
    }

    // 부등호 조건 확인
    static boolean check(String temp) {
        for (int i = 0; i < count; i++) {
            int a = temp.charAt(i) - '0';
            int b = temp.charAt(i + 1) - '0';
            if (input[i].equals(">") && a < b) {
                return false;
            }
            if (input[i].equals("<") && a > b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt(); // 개수 입력
        input = new String[count];

        // 부등호 입력
        for (int i = 0; i < count; i++) {
            input[i] = sc.next();
        }

        permutation(0, "");
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));

        sc.close();
    }
}
