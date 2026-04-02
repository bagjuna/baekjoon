import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 10816 숫자카드 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N1 = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N1; i++) {
            String s = st.nextToken();
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        int N2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N2; i++) {
            String s = st.nextToken();
            if (map.containsKey(s)) {
                bw.write(map.get(s)+" ");
            } else {
                bw.write(0+" ");

            }
        }
        bw.flush();

    }
}
