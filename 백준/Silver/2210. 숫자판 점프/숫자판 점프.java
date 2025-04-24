
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static char[][] chess = new char[5][5];
    static Set<String> set = new HashSet();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                chess[i][j] = split[j].charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, new StringBuilder().append(chess[i][j]));
            }
        }

        System.out.println(set.size());

    }

    public static void dfs(int h, int w, StringBuilder word) {
        if (word.length() == 6) {
            set.add(word.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newH = h + dy[i];
            int newW = w + dx[i];
            if (newH >= 0 && newH < 5 && newW >= 0 && newW < 5) {
                StringBuilder next = new StringBuilder(word);
                next.append(chess[newH][newW]);
                dfs(newH, newW, next);

            }
        }

    }
}