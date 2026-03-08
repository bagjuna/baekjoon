import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int basket[] = new int[N+1];

        int i = 0;
        int j = 0;
        int k = 0;
        for (int l = 0; l < M; l++) {
            i = scanner.nextInt();
            j = scanner.nextInt();
            k = scanner.nextInt();
            for (int a = i ; a <= j; a++) {
                basket[a] = k;
            }
        }
        for (int l = 1; l < N+1; l++) {
            System.out.print(basket[l]+" ");
        }

    }
}