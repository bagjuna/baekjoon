import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        int year = 1;

        while (true) {
            if ((year - 1) % 15 + 1 == E &&
                (year - 1) % 28 + 1 == S &&
                (year - 1) % 19 + 1 == M) {
                break;
            }
            year++;
        }

        System.out.println(year);
    }
}