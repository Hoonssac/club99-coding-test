import java.util.*;

public class Programmers_172927 {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int dia = picks[0]; // 다이아 곡괭이 개수
        int iron = picks[1]; // 철 곡괭이 개수
        int stone = picks[2]; // 돌 곡괭이 개수

        // 전체 곡괭이의 개수
        int totalPicks = dia + iron + stone;

        // 광석 총 개수
        int totalMinerals = minerals.length;

        // 5개씩 그룹화해서 피로도 계산
        int[][] mineralsGroup = new int[totalPicks][6];

        for (int i = 0; i < Math.min(totalPicks * 5, totalMinerals); i += 5) {
            int sum = 0; // 현재 그룹의 피로도
            int damage = 0; // 각 광물에 대한 피로도

            for (int j = i; j < Math.min(i + 5, totalMinerals); j++) {
                switch (minerals[j]) {
                    case "diamond":
                        damage = 25;
                        break;
                    case "iron":
                        damage = 5;
                        break;
                    case "stone":
                        damage = 1;
                        break;
                }
                sum += damage; // 피로도 총합 업데이트
                mineralsGroup[i / 5][j % 5 + 1] = damage; // 각 광물의 피로도 저장
            }
            mineralsGroup[i / 5][0] = sum; // 현재 그룹의 총 피로도 저장
        }

        // 피로도 합 기준으로 내림차순 정렬
        Arrays.sort(mineralsGroup, (o1, o2) -> o2[0] - o1[0]);


        for (int i = 0; i < totalPicks; i++) {
            int[] temp = mineralsGroup[i];
            String pick = "";
            
            // 사용한 곡괭이의 개수를 줄이고, 어떤 곡괭이를 사용했는 지 저장
            if (dia > 0) {
                dia -= 1;
                pick = "diamond";
            }
            else if (iron > 0) {
                iron -= 1;
                pick = "iron";
            }
            else if (stone > 0) {
                stone -= 1;
                pick = "stone";
            }

            // 광물별 피로도 계산
            for (int j = 1; j < 6; j++) {
                switch (pick) {
                    case "diamond":
                        answer += (int) Math.ceil(temp[j] / 25.0);
                        break;
                    case "iron":
                        answer += (int) Math.ceil(temp[j] / 5.0);
                        break;
                    case "stone":
                        answer += temp[j];
                        break;
                }
            }
        }        
        return answer;
    }
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }
}
