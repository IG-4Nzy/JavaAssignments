import java.util.Scanner;

class PrimeOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean isPrime = true;
            System.out.println("Enter a number");
            int number = scanner.nextInt();
            if (number <= 2) {
                System.out.println("Is not a prime number \n");
                isPrime = false;
                continue;
            }
            for (int i = 2; i < number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
            System.out.println(isPrime ? "is Prime number \n" : "is not prime number");
        }

    }
}