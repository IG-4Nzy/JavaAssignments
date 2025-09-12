abstract class BankAccount {
    abstract double getAccountBalance();

    abstract void setAccountBalance(double balance);
}

class Account extends BankAccount {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public double getAccountBalance() {
        return balance;
    }

    @Override
    public void setAccountBalance(double balance) {
        this.balance = balance;
    }
}

class AbstractBankAccount {
    public static void main(String[] args) {
        BankAccount account = new Account(2000);
        System.out.println("Balance :- " + account.getAccountBalance());

        System.out.println("Balance increment with 1000 \n");
        account.setAccountBalance(account.getAccountBalance() + 1000);
        System.out.println("Incremented balance :- " + account.getAccountBalance());
    }
}