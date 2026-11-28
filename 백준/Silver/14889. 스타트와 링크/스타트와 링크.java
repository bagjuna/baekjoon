
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean [] visited;
    static int N;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int cnt, int start){
        if(cnt == N / 2) {
            caldiff();
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(cnt + 1, i + 1);
            visited[i] = false;
        }

    }

    static void caldiff(){
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(!visited[i] && !visited[j]){
                    sumA += map[i][j];
                    sumA += map[j][i];
                }else if(visited[i] && visited[j]){
                    sumB += map[i][j];
                    sumB += map[j][i];
                }
            }
        }
        result = Integer.min(result, Math.abs(sumA - sumB));
        if(result == 0){
            System.out.println(0);
            System.exit(0);
        }
    }
}
