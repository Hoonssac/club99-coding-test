import java.util.*;

class Programmers_42747 {
    public int solution(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        
        if (citations.length == 1) {
            if (citations[0] == 0) {
                h = 0;
            }
            else {
                h = 1;
            }
        }
        else {
            if (citations[0] >= citations.length) {
                h = citations.length;
            }
            else {
                int temp = citations[0];
                // 3, 4, 4, 5, 6, 6, 7
                
                while(true) {
                    int count = 0;
                    for (int i = 0; i < citations.length; i++) {
                        if (citations[i] >= temp) {
                            count++;
                        }
                    }
                    
                    if (count > temp) {
                        temp++;
                    }
                    else {
                        if (count < temp) {
                            h = temp - 1;
                        }
                        else {
                            h = temp; 
                        }
                        break;
                    }  
                }
            }
        }   
        return h;
    }
}