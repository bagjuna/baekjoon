import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isNotPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimes();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            
            for (int i = 2; i <= N / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[N - i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        
    }
    
    static boolean isPrime(int x){
        if(x < 2) return false;
        if(x == 2 || x == 3) return true;
        if(x % 2 == 0 || x % 3 == 0) return false;
        
        for(int i = 5 ; i * i <= x; i++){
            if(x % i == 0 || x % (i+2) == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void getPrimes() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
