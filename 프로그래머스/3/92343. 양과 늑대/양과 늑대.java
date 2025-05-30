import java.util.*;
class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int length = info.length;
        Node[] graph = new Node[length];
        for(int i :info){
            graph[i] = new Node(i);
        }
        
        for(int[] edge :edges){
            int start = edge[0];
            int end = edge[1];
            graph[start].addset(end);
        }
        
        return answer;
        
        
    }
    static class Node{
        int state;
        HashSet<Integer> set = new HashSet<>();
        Node(int state) {
            this.state = state;
        }
        void addset(int value){
            set.add(value);
        }
    }
}