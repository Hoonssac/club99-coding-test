import java.util.*;

public class LeetCode_436 {
    public int[] findRightInterval(int[][] intervals) {
        // [[3,4], [2,3], [1,2]]
        int[] answer = new int[intervals.length];
        HashMap<Integer, Integer> startIndexMap = new HashMap<>();

        // 시작점과 인덱스를 매핑하여 저장
        for (int i = 0; i < intervals.length; i++) {
            startIndexMap.put(intervals[i][0], i);
        }

        // startIndexMap
        // Key -> Value
        // 3 -> 0
        // 2 -> 1
        // 1 -> 2

        // 시작점 배열을 정렬
        int[][] sortedIntervals = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            sortedIntervals[i] = intervals[i];
        }
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        // sortedIntervals
        // [[1,2], [2,3], [3,4]]

        // 각 구간의 끝점에 대해 이진 탐색
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int index = binarySearch(sortedIntervals, end);
            if (index == -1) {
                answer[i] = -1;
            }
            else {
                answer[i] = startIndexMap.get(sortedIntervals[index][0]);
            }
        }

        return answer;                      
    }

    // 이진 탐색
    public int binarySearch(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] >= target) {
                result = mid; // 가능한 인덱스 저장
                right = mid - 1; // 더 작은 인덱스를 찾기 위해 왼쪽으로 이동
            }
            else {
                left = mid + 1; // 더 큰 인덱스를 찾기 위해 오른쪽으로 이동
            }
        }
        
        return result;
    }
}
