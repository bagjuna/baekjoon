class Solution {
    public int solution(int storey) {
        int cnt = 0;
        
        while(0 < storey){
            int digit = storey % 10;
            storey = storey / 10;
            
            if (digit > 5) {
                // 6, 7, 8, 9인 경우: 올림이 이득
                cnt += (10 - digit);
                storey++;
            }
            else if (digit < 5) {
                cnt += digit;
            }
            else {
                if (storey % 10 >= 5){
                    cnt += 5;
                    storey++;
                }
                else{
                    cnt += 5;
                }
                    
            }
        }
        return cnt;
    }
}