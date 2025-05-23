import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int minValue = Integer.MAX_VALUE;
        // 모든 간선 순회
        for(int i = 0; i< wires.length;i++){
            HashSet<Integer>[] graph = new HashSet[n+1];
            // 그 중 하나씩 간선을 없에서 bfs에 돌린다.
            for(int j = 1; j< n+1;j++){
                graph[j] = new HashSet<>();
            }
            for(int j = 0; j < wires.length; j++){
                int a = wires[j][0];
                int b = wires[j][1];
                if(j==i) continue;
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int count = bfs(graph);
            int count2 = n - count;
            minValue = Integer.min(minValue, Math.abs(count - count2));
            
        }
        
        
        return minValue;
    }
    
    static int bfs(HashSet<Integer>[] graph){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        HashSet<Integer> visited = new HashSet<>();
        int cnt = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
          
            HashSet<Integer>list = graph[curr];
                for(int next :list){
                     if(!visited.contains(next)){
                         visited.add(curr);
                         q.add(next);
                         cnt++;
                     }
                }
              
            
        }
        return cnt;
    }
}