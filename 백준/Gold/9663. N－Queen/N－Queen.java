import java.util.*;

public class Main {
    static int count, N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0. N 입력 받기
        // 배열 N x N 배열의 체스판 초기화
        N = sc.nextInt();
        arr = new int[N];
        
        // 1. 0 to N x N, 모두 순회에 dfs(j) 수행
        dfs(0);
        System.out.println(count);
        
    }
    static void dfs(int depth){
        // 탈출 조건 depth == N 개면 탈출
        if(depth == N){
            count++;
            return;
        }
        // 1. 현재 행에서 0번부터 N번 열까지 일단 놔보기
        for(int i= 0; i< N; i++){
            arr[depth] = i;
            if(valid(depth)){
                dfs(depth+1);
            }
            arr[depth] = 0;
        }
            
        
        
    }
    
    public static boolean valid(int col){
        
        // 1. 0번부터 현재 열까지 순회
        for(int i = 0; i < col; i++){
            // 2-1 같은 행에 있는지 확인 있으면 false
            if(arr[col] == arr[i])
                return false;
            // 2-2 대각선이 있는지 확인 있으면 false
                // 현재 열 col과 i번 col과의 차 
                // == 
                // 현재 행 arr[col] 과 arr[i]의 차
                // 라면 false
            int absCol = Math.abs(col - i);
            int absVer = Math.abs(arr[col] - arr[i]);
            if(absCol == absVer)
                return false;
        }
        
        return true;
        
    }
}