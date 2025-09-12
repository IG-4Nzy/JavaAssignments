import java.util.Scanner;

class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the month : ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
                System.out.println("\nJanuary");
                break;
            case 2:
                System.out.println("\nFebruary");
                break;
            default:
                System.out.println("\ninvalid month");

        }
    }
}