import java.util.*;

public class Main {
    static int dx[] = {2,1,-1,-2,-1,-2,1,2 };
    static int dy[] = {1,2,2,1,-2,-1,-2,-1 };
    static Node start;
    static Node end;
    static int max;
    static int K;
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        
        for(int i = 0; i< N; i++){
            K = sc.nextInt();
            int[][] arr = new int[K][K];
            visited = new boolean[K][K];
            start = new Node(sc.nextInt(), sc.nextInt(), 0);
            end = new Node(sc.nextInt(), sc.nextInt(), 0);
            max = Integer.MAX_VALUE;
            bfs(start);
            System.out.println(max);
        }
        
    }
    
    static void bfs(Node startP){
        Deque<Node> q = new ArrayDeque<>();
        q.add(startP);
        visited[startP.x][startP.y] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == end.x && curr.y == end.y){
                max = curr.cnt;
                return;
            }
            if(curr.cnt > max){
                continue;    
            }
            
            for(int i = 0 ; i < 8; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(valid(nx, ny)){
                   if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, curr.cnt + 1));
                    }
                }
                
                }
        }
        
        
    
        
        
        
    }
    
    static boolean valid(int x, int y){
        return x >= 0 && y >= 0 && x < K && y < K;
    }
    
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
    }
}
