import java.util.*;
import java.io.*;

public class Main {
    static int X, Y, Z;
    static int[][][] map;
    static int cnt;
    
    static int[] dx = {0,0,0,0,-1,1};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {-1,1,0,0,0,0};
    static Deque<Node> q;
    
    static class Node{
        int x;
        int y;
        int z;
        int day;
        public Node(int z, int y, int x, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        
        map = new int[Z][Y][X];
        q = new ArrayDeque<>();
        
        for(int i = 0; i < Z; i++){
            for(int j = 0 ; j < Y; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < X; k++){
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 1) 
                        q.add(new Node(i,j,k,0));
                    map[i][j][k] = temp;
                }
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
            cnt = Integer.max(cnt, curr.day);
            if(map[curr.z][curr.y][curr.x] == 1){
            for(int i = 0; i < 6; i++){
                int nextx = curr.x + dx[i];
                int nexty = curr.y + dy[i];
                int nextz = curr.z + dz[i];
                if(valid(nextz,nexty,nextx) && map[nextz][nexty][nextx] == 0){
                    q.add(new Node(nextz,nexty,nextx,cnt + 1));
                    map[nextz][nexty][nextx] = 1;
                }              
            }
        }
        }
    }
    
    static boolean valid(int cz, int cy, int cx){
        return cx >= 0 && cx < X && cy >= 0 && cy < Y && cz >= 0 && cz < Z;
    }
    
    static boolean finish(){
        for(int i = 0; i < Z; i++){
            for(int j = 0 ; j < Y; j++){
                for(int k = 0; k < X; k++){
                    if(map[i][j][k] == 0) 
                        return false;
                }
            }
        }
        return true;
    }
    
}
