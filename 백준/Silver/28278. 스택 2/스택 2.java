import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("1")) {
                stack.push(split[1]);
            } else if (split[0].equals("2")) {
                if (stack.isEmpty()) {
                    bw.write("-1" + "\n");
                }
                else {
                    bw.write(stack.pop()+"\n");

                }
            } else if (split[0].equals("3")) {
                bw.write(stack.size() + "\n");
            }else if (split[0].equals("4")) {
                if (stack.isEmpty()) {
                    bw.write(1+"\n");
                }else {
                    bw.write(0+"\n");

                }
            } else if (split[0].equals("5")) {
                if (stack.isEmpty()) {
                    bw.write(-1+"\n");

                }
                else {
                    bw.write(stack.peek()+"\n");

                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}