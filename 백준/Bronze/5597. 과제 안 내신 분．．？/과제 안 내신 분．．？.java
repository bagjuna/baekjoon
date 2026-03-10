import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int students[] = new int[31]; //0~30
        int No[] = new int[2];
        Scanner scanner = new Scanner(System.in);
        int a=0;
        for (int i = 0; i < 28; i++) {
            a = scanner.nextInt();
            students[a] = a;
        }
        a=0;

        for (int i = 1; i < 31; i++) {
            if(students[i] != i)No[a++]=i;
        }
        System.out.print(No[0] +" "+ No[1]);

    }
}