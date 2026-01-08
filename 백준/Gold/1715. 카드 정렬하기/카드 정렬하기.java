
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.valueOf(br.readLine()));
        }
        int d1 = 0;
        int d2 = 0;
        int sum = 0;
        while (pq.size() > 1) {
            d1 = pq.remove();
            d2 = pq.remove();
            sum += d1 + d2;
            pq.add(d1 + d2);
        }
        System.out.println(sum);
    }
}