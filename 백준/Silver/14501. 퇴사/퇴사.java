import java.util.*;


public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] work = new int [N][2];
        
        for(int i = 0; i < N; i++) {
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }
        
        int[] dp = new int[N + 1];
        
        for(int i = 0; i < N; i++) {
            for(int j = i+work[i][0]; j<N+1; j++ ){
                if(dp[j] < dp[i] + work[i][1]){
                    dp[j] = dp[i]+ work[i][1];
                }
            }
            
        }
        System.out.println(dp[dp.length-1]);
        
        
    }
    
   
    
}
