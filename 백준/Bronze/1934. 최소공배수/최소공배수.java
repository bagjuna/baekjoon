import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            System.out.println(lcm(sc.nextInt(), sc.nextInt()));
        }
    }
    
    static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
    
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
