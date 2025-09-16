import java.util.*;
import java.io.*;

class Solution {
    static List<String> answer;
    static boolean[] visited; //티켓 사용 여부 확인용 배열
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();

        // 1. 도착지 기준 알파벳 오름차순으로 정렬
        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));

        dfs(1, "ICN", "ICN", tickets);
        
        // 2. 모든 경로를 찾은 뒤 전체 경로를 정렬
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    
    private void dfs(int cnt, String path, String curLocation, String[][] tickets){
        if(cnt == tickets.length + 1){
            answer.add(path); 
            return;
        }
        
        for(int i =0; i<tickets.length; i++){
            //현재 티켓을 사용한적 없고, 티켓의 출발지가 현재 위치가 같은지 확인
            if(!visited[i] && tickets[i][0].equals(curLocation)){
                visited[i] = true; //현재 티켓 사용 처리
                dfs(cnt + 1, path + " " + tickets[i][1], tickets[i][1], tickets); 
                visited[i] = false; //현재 티켓 미사용 처리
            }
        }
        
        
    }
}