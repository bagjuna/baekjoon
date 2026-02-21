import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 2];
        for(int i = 1; i < N+1; i++){
            arr[i] = i;
        }
        
        for(int i = 0; i< M;i++){
            int start = sc.nextInt();
            int to = sc.nextInt();
            int temp = arr[start];
            arr[start] = arr[to];
            arr[to] = temp;
        }
        
          for(int i = 1; i < N + 1; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
    //  1 2 3 4 5
    //  2 1 3 4 5
    //  2 1 4 3 5
    //  3 1 4 2 5
    //  3 1 4 2 5
}
