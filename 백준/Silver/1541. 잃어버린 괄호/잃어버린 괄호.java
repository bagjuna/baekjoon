import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int sum = Integer.MAX_VALUE;

        String[] split1 = input.split("-");

        int result = 0;

        for (int i = 0; i < split1.length; i++) {
            int temp = 0;

            String[] split2 = split1[i].split("\\+");

            for (int j = 0; j < split2.length; j++) {
                temp += Integer.parseInt(split2[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            }else {
                sum -= temp;
            }

        }
        System.out.println(sum);

    }
}