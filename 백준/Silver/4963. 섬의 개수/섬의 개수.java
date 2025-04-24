
import java.util.Scanner;


public class Main {


    static int[][] box;
    static boolean[][] visited;
    static int wSize;
    static int hSize;
    static int cnt;
    // 8방향
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int b = 1;
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            cnt = 0;
            wSize = a;
            hSize = b;
            box = new int[b][a];
            visited = new boolean[b][a];

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    box[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    if (box[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);


        }


    }

    static boolean dfs(int h, int w) {
        visited[h][w] = true;
        for (int i = 0; i < 8; i++) {
            int tempH = h + dy[i];
            int tempW = w + dx[i];
            if (tempW >= 0 && tempW < wSize && tempH >= 0 && tempH < hSize) {
                if (box[tempH][tempW] == 1 && !visited[tempH][tempW]) {
                    dfs(tempH, tempW);
                }
            }
        }
        return true;
    }

}

