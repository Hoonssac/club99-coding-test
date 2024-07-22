class Solution {
    
    public int[] solution(long n) {
        String input[] = Long.toString(n).split("");
        int answer[] = new int[input.length];

        int j = 0;
        
        for (int i = Long.toString(n).length() - 1; i >= 0; i--) {
            answer[j] = Integer.parseInt(input[i]);
            j++;
        }
        return answer;
    }
}