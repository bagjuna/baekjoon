import java.util.*;


public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(lcm(a,b));
        
    }
    
    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
