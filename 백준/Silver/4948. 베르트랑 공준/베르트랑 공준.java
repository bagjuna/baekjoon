import java.util.*;

public class Main {
    static boolean[] isPrime = new boolean[246913];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 미리 소수 구해놓기 (에라토스테네스의 체)
        getPrimes();
        
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;
            
            int cnt = 0;
            // 2. n보다 크고 2n보다 작거나 같은 소수 개수 세기
            for(int i = n + 1; i <= 2 * n; i++){
                if(!isPrime[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
    
    public static void getPrimes() {
        isPrime[0] = isPrime[1] = true;
        
        for(int i = 2; i * i <= 246912; i++ ){
            if(!isPrime[i]){
                for(int j = i*i ; j <= 246912; j += i){
                    isPrime[j] = true;
                }
            }
        }
    }
}
