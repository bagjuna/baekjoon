import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1,0,0,1}; 
    static int[] dy = {0,-1,1,0};   
    static int N;
    static int countPerDanji;
    
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        // 1. (0,0) 부터 (N,N) 까지 돌면서 dfs    
        ArrayList<Integer> countList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    countPerDanji = 0;
                    dfs(i, j);
                    countList.add(countPerDanji);
                }
            }
        
            
        }
        
        System.out.println(countList.size());
        Collections.sort(countList);
        for(int temp: countList){
            System.out.println(temp);
        }
    }
    
    static void dfs(int y, int x){
        visited[y][x] = true;
        countPerDanji++;
        
        for(int i = 0; i < 4 ; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];
            if(valid(newX, newY) && !visited[newY][newX] && graph[newY][newX] == 1){
                dfs(newY, newX);
            }
        }
    }
    
    static boolean valid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
