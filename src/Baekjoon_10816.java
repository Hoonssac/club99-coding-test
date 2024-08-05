import java.util.*;

public class Baekjoon_10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if (!countMap.containsKey(value)) {
                countMap.put(value, 1);
            }
            else {
                countMap.replace(value, countMap.get(value) + 1);
            }
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int input = sc.nextInt();
            if (countMap.containsKey(input)) {
                result.append(Integer.toString(countMap.get(input)) + " ");
            }
            else {
                result.append("0 ");
            }
        }
        
        System.out.println(result.toString().trim());
        

        sc.close();
    }
}

// 개선된 코드
// import java.util.*;

// public class Baekjoon_10816 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         HashMap<Integer, Integer> countMap = new HashMap<>();
//         StringBuilder result = new StringBuilder();

//         int N = sc.nextInt();
//         for (int i = 0; i < N; i++) {
//             int value = sc.nextInt();
//             countMap.put(value, countMap.getOrDefault(value, 0) + 1);
//         }

//         int M = sc.nextInt();
//         for (int i = 0; i < M; i++) {
//             int input = sc.nextInt();
//             result.append(countMap.getOrDefault(input, 0)).append(" ");
//         }
        
//         System.out.println(result.toString().trim());
//         sc.close();
//     }
// }
