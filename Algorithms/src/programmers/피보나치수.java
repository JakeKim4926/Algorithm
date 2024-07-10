package programmers;

public class 피보나치수 {
    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }

        return fib[n];
    }
}
