
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 파일합치기 3 (백준 13975)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        for (int i = 0; i < N; i++) {
            Long n = Long.parseLong(br.readLine());
            PriorityQueue<Long> list = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Long sum = 0L;
            for (int j = 0; j < n; j++) {
                list.add(Long.valueOf(st.nextToken()));
            }

            while (list.size() > 1) {
                Long poll1 = list.poll();
                Long poll2 = list.poll();

                sum += poll1 + poll2;
                list.add(poll1 + poll2);
            }
            System.out.println(sum);

        }
    }
}
