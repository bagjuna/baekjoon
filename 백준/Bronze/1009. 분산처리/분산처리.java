import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ;i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 1;
            
            int lastA = a % 10;
            
            if (lastA == 0) {
                System.out.println(10);
                continue;
            }
            
            int lastB = b % 4;
            if (lastB == 0) lastB = 4;
            
            for (int j = 0; j < lastB; j++) {
                result = (result * lastA) % 10;
            }
            
            System.out.println(result);
        }
    }
}
