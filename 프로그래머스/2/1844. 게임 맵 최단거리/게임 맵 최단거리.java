
import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N;
    static int M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1));
        maps[0][0] = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == N-1 && curr.y == M-1 ){
                return curr.cnt;
            }
            for(int i = 0 ; i< 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny >= M ) continue;
                if(maps[nx][ny]==1){
                    maps[nx][ny] = 0;
                    q.add(new Node(nx,ny,curr.cnt+1));
                }
            }
        }
        return -1;
    }

    static class Node{
        int x, y, cnt;

        Node(int a,int b, int c){
            x = a;
            y = b;
            cnt = c;
        }
    }

}