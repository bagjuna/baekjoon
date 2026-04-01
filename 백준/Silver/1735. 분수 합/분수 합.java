import java.util.*;

public class Main {
    public static void main(String[] args) {
        // a  c
        // b  d
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();        
        int A = a*d + b*c;
        int B = b * d;
        int k = gcd(A, B);
        System.out.print(A / k + " ");
        System.out.print(B / k);
    }
    
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
