import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 1;
        int b = 1;
        int result = 1;
        for (int i = 2; i < N; i++) {
            a = b;
            b = result; 
            result = a + b;

        }
        System.out.println(result + " " + (N - 2));
    }
}
