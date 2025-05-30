import java.util.*;
class Solution {
    static int N;
    public int solution(int n, int[][] wires) {
        N = n;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i< wires.length; i++){
            List<Integer>[] graph = new ArrayList[n + 1];
            for(int j = 0; j< n + 1 ;j++){
                graph[j] = new ArrayList<>();
            }
            
            for(int j =0 ;j <wires.length;j++){
                if(i==j) continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            
            
          int count = bfs(graph);
            int count2 = n - count;
            minValue = Integer.min(minValue, Math.abs(count - count2));
            
        }
        return minValue;
    }
    
     static int bfs(List<Integer>[] graph){
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            int cnt = 1;
            HashSet<Integer> visited = new HashSet<>();
         
            while(!q.isEmpty()){
                int curr = q.poll();
                
                for(int next: graph[curr]){
                    if(visited.contains(next)) continue;
                    q.add(next);
                    visited.add(curr);
                    cnt++;
                }
            }
            return cnt;
        }
}