// discount의 0번째 제품부터 "discount.length - 필요한 총 물건의 개수"번째 까지만 순회

// - 예외 사항
// discount하는 제품이 want에 있지 않은 경우
// 원하는 제품의 개수보다 discount하는 제품의 개수가 더 많은 경우

import java.util.HashMap;

public class Programmers_131127 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalCount = 0;
        int nowCount = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();

        // 필요한 물건의 총 개수
        for (int num : number) {
            totalCount += num;
        }

        for (int i = 0; i <= discount.length - totalCount; i++) {
            // hashMap 입력
            for (int k = 0; k < want.length; k++) {
                wantMap.put(want[k], number[k]);
            }  
            nowCount = 10;


            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j]) == false || wantMap.get(discount[j]) <= 0) {
                    break;
                }
                else {
                    wantMap.put(discount[j], wantMap.get(discount[j]) - 1);
                    nowCount--;
                }
            }
            if (nowCount == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        solution(want, number, discount);
    }
}
