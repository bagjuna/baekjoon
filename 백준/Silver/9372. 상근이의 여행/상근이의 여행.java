import java.util.*;
import java.io.*;

public class Main {
    static int[][] plane;
	static boolean[] visited;
    static int result, N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            
            plane = new int[N+1][N+1];
            visited = new boolean[N+1];
            
            for(int j = 0; j< M; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                plane[u][v] = 1;
                plane[v][u] = 1;
            }
            bfs();
            System.out.println(result - 1);
            
        }
        
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            result++;
            int value = q.poll();
            for(int i = 1; i<=N; i++){
                if(plane[value][i] != 0&& !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
