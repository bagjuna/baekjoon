import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt()%42;
        }
        int sum = 10;
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                if(array[i]==array[j]){
                    sum -= 1;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}