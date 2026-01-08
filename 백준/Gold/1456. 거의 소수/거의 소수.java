import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        
        int maxLimit = 10000000;
        // isNotPrime[i] == false 이면 i는 소수
        boolean[] isNotPrime = new boolean[maxLimit + 1];
        
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        
        for(int i = 2; i <= Math.sqrt(maxLimit); i++){
            if(!isNotPrime[i]){
                for (int j = i * i; j <= maxLimit; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 2; i <= maxLimit; i++){
            if(!isNotPrime[i]){
                long p = i; // long으로 변환
                
                long temp = p * p;
                
                while(temp <= end){
                    if(temp >= start){
                        cnt++;
                    }
                
                    if(end / p < temp) break;
                    
                    temp *= p;
                }
            }
        }
        
        System.out.println(cnt);
        
        
    }
}
