import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LeetCode_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 생성
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // 그래프 입력
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0); // 출발지
            String dest = equations.get(i).get(1); // 도착지
            double value = values[i]; // 가중치

			// 출발지가 존재하지 않으면 도착지와 가중치 입력
            graph.computeIfAbsent(start, k -> new HashMap<>()).put(dest, value);
            // 도착지가 존재하지 않으면 출발지와 가중치의 역수를 입력
            graph.computeIfAbsent(dest, k -> new HashMap<>()).put(start, 1 / value);
        }
        
        double[] answer = new double[queries.size()]; // 최종 출력 배열

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0); // queries의 출발지 추출
            String dest = queries.get(i).get(1); // queries의 도착지 추출
            Set<String> visited = new HashSet<>(); // 방문 여부 Set 생성

            answer[i] = dfs(graph, start, dest, visited); // dfs 호출 후 반환값 저장
        }

        return answer; // 최종 결과 반환

    }
    
    // 그래프 탐색
    public double dfs(Map<String, Map<String, Double>> graph, String start, String dest, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0; // 만약 출발지가 그래프에 없으면 -1 반환
        }
        if (start.equals(dest)) {
            return 1.0; // 출발지와 도착지가 같으면 1 반환
        }
        visited.add(start); // 방문 여부 표시

		// 정점에 연결된 모든 이웃 정점과 가중치를 가져옴
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
        	// 방문하지 않았을 경우
            if (!visited.contains(neighbor.getKey())) {
            	// 현재 정점에서 도착지로 가는 경로를 찾기 위해 dfs 재귀 호출
                double result = dfs(graph, neighbor.getKey(), dest, visited);
                // 도착지에 도달한 수 있는 경로가 발견된 경우
                if (result != -1.0) {
                	// 해당 경로의 가중치에 현재 이웃 정점으로 가는 가중치를 곱하여 반환
                    return result * neighbor.getValue();
                }
            }
        }
        return -1.0; // 경로를 찾지 못했을 경우 -1.0 반환
    }
}