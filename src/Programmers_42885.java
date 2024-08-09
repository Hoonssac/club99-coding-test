
import java.util.Arrays;

// 구명보트 최대 2명, 무게 제한 O
// 70, 50, 80, 50 무게 제한 100이라면,
// 2번째 4번째 탑승
// 구명보트 최대한 적게 사용

public class Programmers_42885 {
    public static int solution(int[] people, int limit) {
        int count = 0;
        int startIdx = 0;
        int endIdx = people.length - 1;
        Arrays.sort(people);

        while (startIdx <= endIdx) {

            // 두 사람 무게의 합이 limit 이하면 함께 탑승 가능
            // 두 사람이 탑승했으므로, startIdx, endIdx 모두 증가/보트 수 증가
            if (people[startIdx] + people[endIdx] <= limit) {
                startIdx++;
                endIdx--;
                count++;
            }
            
            // 두 사람 무게의 합이 limit 이상이면
            // endIdx에 있던 사람은 무조건 혼자 탑승 해야히므로, endIdx감소/보트 수 증가
            else {
                endIdx--; 
                count++;
            }
        }


        return count;
    }


    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}
