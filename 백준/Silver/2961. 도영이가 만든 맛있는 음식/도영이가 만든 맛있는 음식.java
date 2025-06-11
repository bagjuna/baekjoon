import java.util.*;

public class Main {
    static int[][] foods;
    static int N;
    static int min;
    static boolean[] visited;
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        min = Integer.MAX_VALUE;
        N = sc.nextInt();
        foods = new int[N][2];
        visited = new boolean[N];
       
        for(int i =0; i < N; i++){
            foods[i][0] = sc.nextInt();
            foods[i][1] = sc.nextInt();
        }
        
          
        if(N==1) {
            System.out.println(Math.abs(foods[0][0] - foods[0][1]));
            return;
        }
        for(int i =0; i < N; i++){
            visited[i] = true;
            dfs(i,foods[i][0], foods[i][1],1);
            visited[i] = false;
        }
        System.out.println(min);
        
    }
    static void dfs(int start, int bit, int spicy, int cnt){
        min = Math.min(Math.abs(bit - spicy), min);     
        if(cnt == N){   
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            int n_bit = bit * foods[i][0];
            int n_spicy = spicy + foods[i][1];
            visited[i] = true;
            dfs(i, n_bit,n_spicy, cnt+1);
            visited[i] = false;
        }
    }
    

}
