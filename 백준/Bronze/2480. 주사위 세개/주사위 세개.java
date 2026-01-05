
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        if(a==b&&b==c) System.out.println(a*1000+10000);
        else if (a==b||b==c) System.out.println(b*100+1000);
        else if (a==c) System.out.println(a*100+1000);
        else {
            a =(a>b)?(a):(b);
            a = (a>c)?(a):(c);
            System.out.println(a*100);
        }
    }
}