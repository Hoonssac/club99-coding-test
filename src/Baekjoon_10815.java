import java.util.*;

public class Baekjoon_10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> N_set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            N_set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            if (N_set.contains(sc.nextInt())) {
                result.append(1).append(" ");
            }
            else {
                result.append(0).append(" ");
            }
        }
        result.toString().trim();
        System.out.print(result);

        sc.close();
    }
}
