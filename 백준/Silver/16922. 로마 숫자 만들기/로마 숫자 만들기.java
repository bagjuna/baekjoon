import java.util.*;

public class Main {
    static int N;
    static HashSet<Integer> set;
    static int[] letters = new int[]{1, 5, 10, 50};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        set = new HashSet<>();
        N = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(set.size());
    }
    static void dfs(int num, int depth, int start){
        if(depth > N) return;
        if(depth == N){
            set.add(num);
            return;
        }
        for(int i = start;i < 4;i++){
            dfs(num + letters[i], depth + 1,i);
        }
    }
}
