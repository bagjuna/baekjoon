import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i <N; i++){
            for(int j = 0; j<M; j++){
                checkT(i, j); // T자형은 따로
                visited[i][j] = true;
                dfs(i,j,map[i][j],1);
                visited[i][j] = false; 
            }
        }
        
         System.out.println(max);
        
    }
    
    
    static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return; 
        }
        for(int i = 0; i<4; i++){
            int nx = x+ dx[i];
            int ny = y+ dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, sum + map[nx][ny], count + 1);
            visited[nx][ny] = false;
            
        }
    }
    
    static void checkT(int x, int y){
        // 중심을 기준으로 4방향 중 3개만 선택
        int wing = 0;
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;

            wing++;
            sum += map[nx][ny];
            min = Math.min(min, map[nx][ny]);
        }

        if (wing < 3) return;
        if (wing == 4) sum -= min; // 가장 작은 날개 제거

        max = Math.max(max, sum);
    
    }
}
