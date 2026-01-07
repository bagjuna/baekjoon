import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<Edge>[] graph;
    static boolean[] visited;
    static int[] dist;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int to = 0;
			int value = 0;
			while ((to = Integer.parseInt(st.nextToken())) != -1) {
				value = Integer.parseInt(st.nextToken());
				graph[curr].add(new Edge(to, value));
			}
		}
        
        bfs(1);
        int max = 0;
        int index = 0;
        for(int i = 2; i< N + 1;i++){
            if(max < dist[i]){
                max = dist[i];
                index = i;
            }
        }
        

        visited = new boolean[N + 1];
        dist = new int[N + 1];


        bfs(index);
        
        max = 0;
        for(int i: dist){
            max = Math.max(i, max);
        }
        
        System.out.println(max);
        
	}

    static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Edge i : graph[curr]){
                int to = i.to;
                int value = i.value;
                if(!visited[to]){
                    visited[to] = true;
                    q.add(to);
                    dist[to] = dist[curr] + value;
                }
                
            }
        }

    }

	static class Edge {
		int to;
		int value;

		Edge(int to, int value) {
			this.to = to;
			this.value = value;
		}
	}
}

