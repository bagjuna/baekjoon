import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        long start = 1;
        long end = K;
        long answer = 0;
        
        while(start<=end){
            long mid = (start + end) / 2;
            
            if(count(mid) >= K ){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    static long count(long x){
        long count = 0;
        
        for(int i = 1; i <= N; i++){
            count += Math.min(N, x/i);
        }
        
        return count;
    }
    
}
