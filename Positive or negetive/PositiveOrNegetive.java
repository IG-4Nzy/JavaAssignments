import java.util.Scanner;

class PositiveOrNegetive{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();
        System.out.println(number < 0 ? "Negetive" : "Positive");
    }
}