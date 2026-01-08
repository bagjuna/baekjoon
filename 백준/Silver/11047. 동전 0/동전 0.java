
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int N = Integer.parseInt(s1[0]);
        int Money = Integer.parseInt(s1[1]);
        int result = 0;
        TreeSet<Integer> map = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            map.add(Integer.valueOf(br.readLine()));
        }
        for (Integer i : map) {
            result += Money / i;
            Money %= i;
        }

        System.out.println(result);
    }
}
