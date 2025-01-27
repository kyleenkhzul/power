import java.util.Scanner;

public class Power {
    public static int naivePower(int x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        return x * naivePower(x, n - 1);
    }

    public static int unoptimizedDCPower(int x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n % 2 == 0) {
            return unoptimizedDCPower(x, n/2) * unoptimizedDCPower(x, n/2);
        } else {
            return x * unoptimizedDCPower(x, n/2) * unoptimizedDCPower(x, n/2);
        }
    }

    public static int optimizedDCPower(int x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }

        int temp = optimizedDCPower(x, n/2);
        if(n % 2 == 0) {
            return temp*temp;
        }
        else {
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        long startTime, endTime, executionTime;
        Scanner scanner = new Scanner(System.in);

        // Prompt for base and exponent
        System.out.println("What base?");
        int base = scanner.nextInt();
        System.out.println("What exponent?");
        int exponent = scanner.nextInt();

        // Naive Power Calculation
        startTime = System.currentTimeMillis();
        System.out.println("Naive power: " + naivePower(base, exponent));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time of NAIVE power: " + executionTime + " milliseconds\n");

        // Unoptimized Power Calculation
        startTime = System.currentTimeMillis();
        System.out.println("Unoptimized power: " + unoptimizedDCPower(base, exponent));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time of UNOPTIMIZED power: " + executionTime + " milliseconds\n");

        // Optimized Power Calculation
        startTime = System.currentTimeMillis();
        System.out.println("Optimized power: " + optimizedDCPower(base, exponent));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time of OPTIMIZED power: " + executionTime + " milliseconds\n");

        scanner.close();
    }
}
