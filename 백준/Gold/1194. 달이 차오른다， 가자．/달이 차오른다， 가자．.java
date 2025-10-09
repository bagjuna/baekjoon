import java.util.*;


public class Main {
    static char [][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][][] visited;
    static int N;
    static int M;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new char[N][M];

        int startX = -1;
        int startY = -1;
        for(int i = 0; i < N; i++){
            String line = sc.next();
            for(int j = 0; j < M; j++){
                char temp = line.charAt(j);
                map[i][j] = temp; // 맵 데이터 저장

                if(temp == '0'){
                    startX = i;
                    startY = j;
                    map[i][j] = '.'; // 시작점을 빈 공간으로 변경
                }
            }
        }
        
        visited = new boolean[N][M][64];
        int minDist = bfs(startX, startY);
        System.out.println(minDist);
        
    }
    
            
        
      private static int bfs(int startX, int startY){
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(new Node(startX, startY, 0, 0));
        visited[startX][startY][0] = true;
        
        // 탐색 시작
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            // return 도착 점을 찾음
            if(map[curr.row][curr.col] == '1'){
                return curr.cnt;
            }
            for(int i = 0; i< 4; i++){
                int nx = curr.row +dx[i];
                int ny = curr.col + dy[i];
                
                int nd = curr.cnt + 1;
                int nk = curr.key;
                
                // 배열 범위를 벗어난 접근 || 벽은 못지나감
                if(nx < 0 || nx >= N || ny < 0 || ny >= M 
                    || map[nx][ny] == '#' ){
                    continue;
                }
               // [key값 갱신]
                if('A'<=map[nx][ny] && map[nx][ny]<='Z') { // 문 (A~Z)
                    // 열쇠가 없으면 continue;
                    if((nk & (1 << (map[nx][ny]-'A'))) == 0) {
                        continue;
                    }
                } else if('a'<=map[nx][ny] && map[nx][ny]<='z') { // 열쇠인 경우(a~z)
                    nk |= (1 << (map[nx][ny]-'a'));
                }
                
                // 방문 한 곳은 다시 가면 안 됨(nk를 구해야 해서 방문 체크를 여기서 진행)
                if(visited[nx][ny][nk]) {
                    continue;
                }
                
                  // [방문 예약] 나머지 방문 안 한 좌표 중 열쇠가 있는 문, 열쇠, '.' 으로는 모두 이동 가능
                queue.offer(new Node(nx, ny, nd, nk));
                visited[nx][ny][nk] = true;

            }
                
                
        }
        return -1;
    }
    
    
    static class Node {
        int row;
        int col;
        int cnt;
        int key;
        
        Node(int row, int col, int cnt, int key){
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
