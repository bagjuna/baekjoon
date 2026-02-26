import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = sc.nextInt();
        System.out.println(map.getOrDefault(result, 0));
    }
}
