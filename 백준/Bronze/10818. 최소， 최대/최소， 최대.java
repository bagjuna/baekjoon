import java.util.*;

public class Main {
    public static void main(String[] args) {
        int max = - 1_000_000;
        int min = 1_000_000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int temp = sc.nextInt();
            if(max < temp)
                max = temp;
            if(min > temp)
                min = temp;
        }
        System.out.println(min + " " + max);
    }
}
