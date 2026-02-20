import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int a = 0;
        int b = 0;
        int temp = 0;

        int basket[] = new int[N+1];
        for (int i = 1; i < N + 1; i++) {
            basket[i] = i;
        }
        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            temp = basket[a];
            basket[a]=basket[b];
            basket[b] = temp;
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(basket[i]+" ");
        }
    }
}