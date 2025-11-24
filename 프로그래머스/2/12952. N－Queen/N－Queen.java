class Solution {
    static int cnt, N;
    static int[] arr;
    public int solution(int n) {
        // 0. 초기화
        arr= new int[n];
        N = n;
        // 1. 0부터 dfs 호출
        dfs(0);
        
        return cnt;
    }
    
    static void dfs(int depth){
        // [탈출조건] depth(현재 열) == N(정답 열)
        if(depth == N){
            cnt++;
            return;
        }
        // 1. 현재 열에 0부터 N까지 일단 표시해보기
        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(valid(depth)){
                dfs(depth + 1);
            }
        }
    }
    
    static boolean valid(int col){
        
        // 1. 지금 열전까지 모든 열 순휘
        for(int i = 0; i< col; i++){
            
            // 현재 행(arr[col]) 과 같은 행(arr[i]) 있으면 false
            if(arr[col] == arr[i])
                return false;
            
            // 현재 위치와 대각선
            //  i에서 col까지 행 길이와
            //  arr[i] 에서 arr[i] 까지 열 길이가 같으면
            // return;
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        
        return true;
        
    }
}