import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++){
            long temp = sc.nextLong();
            while(true){
                if(isPrime(temp)){
                    System.out.println(temp);
                    break;
                }
                temp++;
            }
        }
        
    }
    
    static boolean isPrime(long x){
        if(x < 2) return false;
        if(x == 2 || x == 3) return true;
        if(x % 2 == 0 || x % 3 == 0) return false;
        
        for(long i = 5; i * i <= x; i += 6){
            if(x % i == 0 || x % (i + 2) == 0){
                return false;
            }            
        }
        return true;
    }
    
}
