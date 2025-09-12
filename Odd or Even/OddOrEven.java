import java.util.Scanner;

class OddOrEven{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter the number : ");
            int number = scanner.nextInt();
            System.out.println(number % 2 == 0 ? "Even" : "Odd");
        }
    }
}