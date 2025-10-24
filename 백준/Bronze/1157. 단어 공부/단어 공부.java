import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();

        int[] count = new int[26]; 

        for (int i = 0; i < N.length(); i++) {
            char c = Character.toUpperCase(N.charAt(i));
            count[c - 'A']++; 
        }

        char result = '?';
        int number = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > number) {
                number = count[i];
                result = (char) (i + 'A');
            } else if (count[i] == number) {
                result = '?';
            }
      }
        System.out.println(result);
    }
}
