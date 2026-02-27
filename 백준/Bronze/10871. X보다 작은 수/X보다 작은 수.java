import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 
        Scanner sc = new Scanner(System.in);
        
        // 1. N 입력 받기
        int N = sc.nextInt();
                
        // 1-2 X 입력 받기
        int X = sc.nextInt();
        
        // 2. 작은 수 출력
        for(int i = 0 ;i < N; i++){
            int temp = sc.nextInt();
            if(temp < X)
                System.out.print(temp + " ");
        }
        
        

    }
}
