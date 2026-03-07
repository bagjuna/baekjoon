import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // 1. T 입력
        int T = sc.nextInt();
        
        for(int i = 0 ; i < T; i++){
            // 2-1. N 입력 받기
            int N = sc.nextInt();
            // 2-2. parent, visited 배열 만들기
            int[] parent = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            
            // 3. N - 1 만큼 순회 해서 배열
            for(int j = 0; j < N - 1; j++){
                int p = sc.nextInt();
                int c = sc.nextInt();
                parent[c] = p;
            }
            
            
            // 4. 조상 찾을 2개의 노드 입력 받기
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            
            // 5. 첫번째 노드의 조상 목록 visited 배열에 채우기
            while(nodeA != 0){
                visited[nodeA] = true;
                nodeA = parent[nodeA];
            }
            
            // 6. nodeB의 조상 노드로 올라가며 visited 했었으면 출력
            while(nodeB != 0){
                if(visited[nodeB]){
                    System.out.println(nodeB);
                    break;
                }
                nodeB = parent[nodeB];
            }
            
        }
        
    }
    
    
}