import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        String s = scanner.next();
        int N = scanner.nextInt();
        for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(s.length() - 1 - i);
                int digit = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
                result += digit * Math.pow(N, i);
        }
        System.out.println(result);
    }
}
