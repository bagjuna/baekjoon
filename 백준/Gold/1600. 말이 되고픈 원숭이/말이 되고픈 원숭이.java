import java.util.*;

public class Main {
    
    public static class Node {
        int x;
        int y;
        int count;
        int k;
        
        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
    
    static int k, w, h;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        
        board = new int[h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        visited = new boolean[h][w][k + 1];
        min = bfs(0,0);
        
        if(min == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(min);
        }
        
    }
    
    static int bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,0,k));
        visited[x][y][k] = true;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == h -1 && curr.y == w -1)
            return curr.count;
            
              for(int i = 0; i < 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(isvalid(nx,ny) && !visited[nx][ny][curr.k]){
                    visited[nx][ny][curr.k] = true;
                    q.add(new Node(nx,ny,curr.count+1,curr.k));
                }
            }
            
            if(curr.k > 0){
                for(int i = 0; i < 8; i++){
                    int nx = curr.x + hdx[i];
                    int ny = curr.y + hdy[i];
                    if(isvalid(nx,ny) && !visited[nx][ny][curr.k -1]){
                        visited[nx][ny][curr.k - 1] = true;
                        q.add(new Node(nx, ny, curr.count+1, curr.k-1));
                    }
                }
            }
        
        }
        return min;
    }
    
    static boolean isvalid(int x, int y){
        return (x >= 0 && x < h && y >= 0 && y < w && board[x][y] == 0);
    }
    
    
}
