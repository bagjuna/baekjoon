
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 개수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 1. N개의 옷 반환
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken();
                String category = st.nextToken();
                hash.put(category, hash.getOrDefault(category, 0) + 1);
            }
            // 2. 전체 개수 계산하여 출력
            int answer = 1;
            for (String s : hash.keySet()) {
                answer *= hash.get(s) + 1;
            }
            System.out.println(answer - 1);
        }


        bw.close();
        br.close();

    }
}
