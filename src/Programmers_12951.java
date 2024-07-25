class Programmers_12915 {
    public StringBuilder solution(String s) {
        StringBuilder modifiedString = new StringBuilder();
        
        // 입력 문자열이 비어 있는지 확인
        if (s == null || s.isEmpty()) {
            return modifiedString; // 빈 문자열일 경우 빈 StringBuilder 반환
        }
        
        boolean isPreviousSpace = true; // 이전 문자가 공백인지 여부
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                modifiedString.append(c); // 공백은 그대로 추가
                isPreviousSpace = true; // 현재 문자가 공백임을 기록
            } else {
                if (isPreviousSpace) {
                    // 이전 문자가 공백일 경우, 첫 글자를 대문자로 변환
                    modifiedString.append(Character.toUpperCase(c));
                } else {
                    // 첫 글자가 아닌 경우 소문자로 변환
                    modifiedString.append(Character.toLowerCase(c));
                }
                isPreviousSpace = false; // 현재 문자가 공백이 아님을 기록
            }
        }
        
        return modifiedString;
    }
}
