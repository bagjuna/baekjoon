import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int a = 1;
        int b = 1;
        int tmp = 0;
        for(int i = 3; i<= N ;i++){
            tmp = a;
            a = b;
            b = tmp + b;
        }
        
        System.out.println(b +" "+ (N-2));
    }
}
