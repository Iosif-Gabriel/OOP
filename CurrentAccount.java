public class CurrentAccount extends Account{

    private int overDraft=10000;

    public CurrentAccount(int number) {
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

    public int getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(int overDraft) {
        this.overDraft = overDraft;
    }
}
