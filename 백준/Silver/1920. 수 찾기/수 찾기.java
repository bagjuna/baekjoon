import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        String[] charArray = br.readLine().split(" ");
        for (String string : charArray) {
            set.add(string);
        }

        int M = Integer.parseInt(br.readLine());
        String[] charArray2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (set.contains(charArray2[i])) {
                charArray2[i] = "1";
            }else {
                charArray2[i] = "0";
            }
        }
        for (String c : charArray2) {
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
    }
}