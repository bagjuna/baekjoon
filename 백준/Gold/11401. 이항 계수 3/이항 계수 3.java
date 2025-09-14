import java.util.*;
import java.io.*;

public class Main {
    static final long DIV = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % DIV;
        }

        long numerator = fact[N];
        
        
        long denominator = (fact[K] * fact[N - K]) % DIV;

        long inverse = power(denominator, DIV - 2);


        long result = (numerator * inverse) % DIV;

        System.out.println(result);
    }


    static long power(long base, long exp) {
        long res = 1;
        base %= DIV;
        while (exp > 0) {

            if (exp % 2 == 1) {
                res = (res * base) % DIV;
            }

            base = (base * base) % DIV;
            exp /= 2;
        }
        return res;
    }
}