public class SavingsAccount extends Account{

    private double interest=0.0001*10;

    public SavingsAccount(int number) {
        super(number);
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addInterest(double sum){
        super.deposit(sum*interest);
    }


}
