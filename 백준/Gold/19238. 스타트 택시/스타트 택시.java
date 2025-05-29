import java.util.*;
import java.io.*;

public class Main {
    static int N, M, fuel;
    static int[][] map;
    static Taxi taxi;
    static List<Passenger> passengers;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        passengers = new ArrayList<Passenger>();
        
        
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            passengers.add(new Passenger(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1 ));
        }
        
        while (!passengers.isEmpty()) {
            // 1. 가장 가까운 승객 찾기
            Passenger p = findNearestPassenger();
            if (p == null) {
                System.out.println(-1);
                return;
            }
            
            // 2. 승객 태우러 이동
            int[][] toPassenger = bfs(taxi.x, taxi.y);
            int distToPassenger = toPassenger[p.startx][p.starty];
            if (distToPassenger == -1 || fuel < distToPassenger) {
                System.out.println(-1);
                return;
            }
            
            fuel -= distToPassenger;
            taxi.x = p.startx;
            taxi.y = p.starty;

             // 3. 목적지로 이동
            if (!moveToDestination(p)) {
                System.out.println(-1);
                return;
            }
            
            // 4. 성공적으로 태운 승객 제거
            passengers.remove(p);
            
        }
        
        System.out.println(fuel); // 남은 연료 출력

    }

    static int[][] bfs(int startx, int starty){
        int[][] dist = new int[N][N];
        for(int[] row: dist) Arrays.fill(row, -1);
        
        Deque<int[]> q =new ArrayDeque<>();
        q.add(new int[]{startx, starty});
        dist[startx][starty] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=N || ny< 0 || ny >= N) 
                if(nx < 0 || nx>=N || ny< 0 || ny >= N) continue;
                if(map[nx][ny] == 1 || dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx,ny});
                
            }
            
            
        }
        return dist;
    }
    
    static Passenger findNearestPassenger(){
        int[][] dist = bfs(taxi.x, taxi.y); // 거리 계산
        
        Passenger selected = null;
        int minDist = Integer.MAX_VALUE;
        
        for (Passenger p : passengers) {
            int d = dist[p.startx][p.starty];
            if (d == -1) continue; // 도달 불가능
            
            if (d < minDist) {
                minDist = d;
                selected = p;
            } else if(d == minDist){
                if (p.startx < selected.startx ||
        (p.startx == selected.startx && p.starty < selected.starty ))
                    {
                        selected = p;
                    }
            }
            
        }
        
        if (selected == null) return null;
        return selected;
    
    }
    
    static boolean moveToDestination(Passenger p){
        int[][] dist = bfs(p.startx, p.starty);
        int d = dist[p.endx][p.endy];
        
        // 도달 불가 or 연료 부족
        if (d == -1 || fuel < d) return false;
        
        // 연료 차감 후 이동
        fuel -= d;
        taxi.x = p.endx;
        taxi.y = p.endy;
        
        // 연료 충전 (이동 거리 * 2)
        fuel += d * 2;
        
        return true;
    }
    
    static class Taxi{
        int x;
        int y;
        Taxi(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static class Passenger{
        int startx, starty, endx, endy;
        Passenger(int a,int b,int c,int d){
            startx = a;
            starty = b;
            endx = c;
            endy = d;
        }
    }
    
}