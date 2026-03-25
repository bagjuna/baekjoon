import java.util.*;

// 1 2 3 4 5
// 2 1 3 4 5
// 2 1 4 3 5
// 3 4 1 2 5

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        for(int i  = 1; i < N + 1 ; i++){
            arr[i] = i;
        }
        
        for(int i  = 0; i < K ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            while (start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; // 시작은 오른쪽으로 한 칸
                end--; // 끝은 왼쪽으로 한 칸
            }
            
        }
        for(int i  = 1; i < N + 1 ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
