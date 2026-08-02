import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // 최대 발생 가능한 흔적 수는 40(물건 수) * 3(최대 흔적) = 120
        // 오버플로우 방지를 위해 충분히 큰 값(INF) 설정
        int INF = 999999;
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0; // 아무것도 훔치지 않았을 때 흔적은 0
        
        for (int[] item : info) {
            int traceA = item[0];
            int traceB = item[1];
            
            // 배열을 뒤에서부터 순회
            for (int j = m - 1; j >= 0; j--) {
                // 1. A가 훔치는 경우
                int costA = dp[j] + traceA;
                
                // 2. B가 훔치는 경우
                int costB = (j >= traceB) ? dp[j - traceB] : INF;
                
                // 둘 중 A의 흔적이 더 적게 남는 최솟값으로 갱신
                dp[j] = Math.min(costA, costB);
            }
        }
        
        int answer = INF;
        
        // A도둑의 흔적이 n 미만인 경우 중 최솟값 찾기
        for (int j = 0; j < m; j++) {
            if (dp[j] < n) {
                answer = Math.min(answer, dp[j]);
            }
        }
        
        return answer == INF ? -1 : answer;
    }
}