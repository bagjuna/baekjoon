import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs,(e1,e2) -> e1[0] - e2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        

        int time = 0;
        int index = 0;
        int total = 0;
        int count = 0;
        
        while(count< jobs.length){
            
            // 현재 시간까지 완료된 모든 작업을 큐에 추가
            while(index < jobs.length && jobs[index][0] <= time){
                pq.add(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
                count++;
            }else{
                time = jobs[index][0];
            }
            
            
            
            
        }
        
        return total / jobs.length;
     
    }
    
   
    
}