import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] parent;
    static Number curr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        visited = new boolean [n + 1];
        parent = new int[n + 1];
        parent[n] = -1;
        Deque<Number> q = new ArrayDeque<>();
        
        q.add(new Number(0, n));
        visited[n] = true;
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr.value == 1){
                break;
            }
            
            if(curr.value % 3 == 0 && !visited[curr.value / 3]){
                q.add(new Number(curr.cnt+1, curr.value / 3));
                parent[curr.value / 3] = curr.value ;
                }
            if(curr.value % 2 == 0 && !visited[curr.value / 2])   {
                q.add(new Number(curr.cnt+1, curr.value / 2));
                parent[curr.value / 2] = curr.value ;
                }
            if(curr.value > 1 && !visited[curr.value -1]){
                parent[curr.value - 1] = curr.value ;
                q.add(new Number(curr.cnt + 1, curr.value - 1));
                }

            
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(curr.cnt + "\n");
        Deque<Integer> stack = new ArrayDeque<>();
        int temp = 1;
        while(temp != -1){
            stack.push(temp);
            temp = parent[temp];
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
    static class Number{
        int cnt;
        int value; 
        
        public Number(int cnt, int value){
            this.value = value;
            this.cnt = cnt;
            visited[value] = true;
        } 
    }
}
