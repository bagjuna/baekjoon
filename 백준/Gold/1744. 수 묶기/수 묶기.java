
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data > 1) {
                plusQ.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minQ.add(data);
            }
        }

        int sum = 0;
        // 양수
        while (plusQ.size() > 1) {
            int first = plusQ.remove();
            int second = plusQ.remove();
            sum += first * second;
        }

        if (!plusQ.isEmpty()) {
            sum += plusQ.remove();
        }

        // 음수
        while (minQ.size() > 1) {
            int first = minQ.remove();
            int second = minQ.remove();
            sum +=  first * second;
        }


        if (!minQ.isEmpty()) {
            if (zero == 0) {
                sum += minQ.remove();
            }

        }
        sum = sum + one;
        System.out.println(sum);

    }
}
