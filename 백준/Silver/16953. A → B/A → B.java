import java.util.Scanner;

public class Main {
    static int start;
    static int end;
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        start = sc.nextInt();
        end = sc.nextInt();
        int cnt = 1;
        dfs(start, cnt);
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(minCount);

    }

    private static void dfs(long num, int cnt) {
        if (num > end) {
            return;
        }
        if (num == end) {
            minCount = Math.min(minCount, cnt);
            return;
        }

        dfs(num * 10 + 1, cnt + 1);
        dfs(num * 2, cnt + 1);

    }

}
