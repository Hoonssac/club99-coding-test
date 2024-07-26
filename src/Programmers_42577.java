import java.util.*;

class Programmers_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
            }
            else {
                continue;
            }
        }
        return answer;
    }
}