import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i =0; i<prices.length; i++){
            int cPrice = prices[i];
            answer[i] = prices.length - 1 - i;
            for(int j = i;j <prices.length;j++){
                if(cPrice > prices[j]){
                    answer[i] = j-i;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}