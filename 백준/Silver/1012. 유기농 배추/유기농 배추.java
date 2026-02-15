import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    
    static int currCnt;
    
    public static void main(String[] args) {
        // 1. 테스트 케이스 갯수
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            N = sc.nextInt(); // 가로
            M = sc.nextInt(); // 세로
            int k = sc.nextInt();
            int answer = 0;
            
            map = new int[M][N];
            visited = new boolean[M][N];
            for(int j = 0; j < k; j++){
                int n = sc.nextInt();
                int m = sc.nextInt();
                map[m][n] = 1;
             }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[j][i] == 1 && !visited[j][i]){
                        dfs(j, i); 
                        answer++;
                    }
                
                }
            }
            
            System.out.println(answer);
            
        }
        
        
        
    }
    
    static void dfs(int y, int x){
        // ArrayDeque<Integer> q = new ArrayDeque<>();
        // 만약 1이라면
        if(!visited[y][x] && map[y][x] == 1){
            currCnt++;
        }
       
        visited[y][x] = true;
        
        // 상 하 좌 우로 이동 answer +1
        for(int i =0; i< 4; i++){
            int nexty = dy[i] + y;
            int nextx = dx[i] + x;
            if(valid(nextx,nexty) && !visited[nexty][nextx]&& map[nexty][nextx] == 1){
                dfs(nexty, nextx);
            }
        }
        
    
    }
    
    static boolean valid(int x,int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    
}
