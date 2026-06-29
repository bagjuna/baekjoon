// 1 - 8
// 
class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] cycles = new int[n];
        
        // 1. 각 신호등의 전체 주기 계산 (G + Y + R)
        for (int i = 0; i < n; i++) {
            cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        // 2. 모든 신호등 주기의 최소공배수(LCM) 구하기
        long maxTime = cycles[0];
        for (int i = 1; i < n; i++) {
            maxTime = lcm(maxTime, cycles[i]);
        }
        
        // 3. 1초 부터 모든 사이클 돌면서 노란불 겹치는 구간 찾기
        for(int t = 1; t <= maxTime; t++){
            boolean isYellow = true;
            
            for(int i = 0; i < n; i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int cycle = cycles[i];
                
                int currTime = (t - 1) % cycle;
                
                if(currTime < g || currTime >= g + y){
                    isYellow = false;
                    break;
                }
            }
            
            if(isYellow){
                return t;
            }
            
            
        }
        
        return -1;
    }
    
    private long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b){
        return (a * b) / gcd(a, b);
    }
}