import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = 0;

    // 19개 테트로미노 모양 정의 (상대좌표 기준)
    static int[][][] tetromino = {
        // ㅡ자
        {{0,0},{0,1},{0,2},{0,3}},
        {{0,0},{1,0},{2,0},{3,0}},
        // ㅁ자
        {{0,0},{0,1},{1,0},{1,1}},
        // ㄴ자
        {{0,0},{1,0},{2,0},{2,1}},
        {{0,0},{0,1},{0,2},{1,0}},
        {{0,0},{0,1},{1,1},{2,1}},
        {{1,0},{1,1},{1,2},{0,2}},
        {{0,0},{1,0},{0,1},{0,2}},
        {{0,0},{1,0},{2,0},{0,1}},
        {{0,0},{0,1},{1,1},{2,1}},
        {{0,0},{0,1},{0,2},{1,2}},
        {{2,0},{0,1},{1,1},{2,1}},
        {{0,0},{1,0},{1,1},{1,2}},
        // Z자
        {{0,0},{0,1},{1,1},{1,2}},
        {{1,0},{0,1},{1,1},{0,2}},
        {{0,0},{1,0},{1,1},{2,1}},
        {{1,0},{1,1},{0,1},{0,2}},
        // ㅗ자 (T)
        {{0,0},{0,1},{0,2},{1,1}},
        {{0,1},{1,0},{1,1},{2,1}},
        {{0,1},{1,0},{1,1},{1,2}},
        {{1,0},{0,1},{1,1},{2,1}},
         // ㅏ자 (L)
        {{0,0},{1,0},{2,0},{1,1}},
        {{0,0},{0,1},{0,2},{1,1}},
        {{0,1},{1,0},{2,0},{1,1}},
        {{0,0},{0,1},{1,1},{2,1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 위치에서 19가지 블록을 다 대입
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int[][] block : tetromino){
                    int sum = 0;
                    boolean isValid = true;
                    for(int[] b : block){
                        int x = i + b[0];
                        int y = j + b[1];
                        if(x < 0 || y < 0 || x >= N || y >= M){
                            isValid = false;
                            break;
                        }
                        sum += map[x][y];
                    }
                    if(isValid) max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}