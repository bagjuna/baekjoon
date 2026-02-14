import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        int min = 64;
        
        
        // 1. 체스판 8 x 8 될만한거 모두 순회
        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int wf = 0;
                int bf = 0;
                // 2. 체스판 8x8 크기만큼 모두 순회
                for(int row = 0; row < 8; row++){
                    for(int col = 0; col < 8; col++){
                        // 
                        if((row + col) % 2 == 0){
                            if(map[i+row][j+col]=='W'){
                                wf++;
                            }else{
                                bf++;
                            }
                        }
                        else {
                             if(map[i+row][j+col]=='W'){
                                bf++;
                            }else{
                                wf++;
                            }
                        }
                    }
                }
                
                int currentMin = Math.min(wf, bf);
                min = Math.min(min, currentMin);
            }
        }
        
        System.out.println(min);
    }
}
