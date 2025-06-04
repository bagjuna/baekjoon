class Solution {
    public int[] solution(int[] sequence, int k) {

		  
        int[] answer = {0, 1_000_000};
        
        int total = 0;
        int start = 0;
        
        for(int end = 0; end< sequence.length; end++){
           total += sequence[end];
            
            while(total>k){
                total -= sequence[start];
                start++;
            }
            
            if(total == k && 
               ((end - start ) < (answer[1] - answer[0]) )){
                   answer[0] = start;
                   answer[1] = end;
                   
            }
        }
        
        

        return answer;
    }
}