import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int cnt = 0;
    static Deque<Node> q;
    
    static class Node{
        int y;
        int x;
        int day;
        public Node(int y, int x, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        q = new ArrayDeque<>();
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) q.add(new Node(i, j, 0));
                map[i][j] = temp;
            }
        }
        
      
        bfs();
        
        
        if(finish())
            System.out.println(cnt);
        else
            System.out.println(-1);
        
        

    }
    
    static void bfs(){
        while(!q.isEmpty()){
            Node curr = q.poll();
            cnt = Math.max(cnt, curr.day);
            for(int i = 0; i < 4; i++){
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                if(valid(nextY,nextX) && map[nextY][nextX] == 0){
                    q.add(new Node(nextY,nextX,cnt + 1));
                    map[nextY][nextX] = 1;
                }
            }
        }
    }
    
    static boolean finish(){
        for(int[] line: map){
            for(int i = 0; i < line.length; i++){
                if(line[i] == 0){
                    return false;
                }    
            }
            
        }
        return true;
    }
    
    static boolean valid(int y, int x){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
}
