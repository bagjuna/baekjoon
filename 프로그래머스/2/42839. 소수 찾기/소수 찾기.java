import java.util.*;

class Solution {
    static Set<Integer> primeSet;
    static int size;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        primeSet = new HashSet<>();
        size = numbers.length();
        
        visited = new boolean[size];
        
        dfs(numbers, "");
        
        
        
        return primeSet.size();
    }
    
    void dfs(String numbers, String curr){
        if(curr.length() != 0){
            int num = Integer.parseInt(curr);
            if(isPrime(num))
                primeSet.add(num);
        }
        
        for(int i =0; i< size;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, curr + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int num){
        if(num<2) return false;
        for(int i = 2; i*i <= num ;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    
}