public class Bank {

    public static void main(String[] args) {
        Account[] acc=new Account[3];
        acc[1]=new SavingsAccount(1234);
        acc[2]=new CurrentAccount(9876);

        Account[] acc2=new Account[3];
        acc2[1]=new SavingsAccount(465);
        acc2[2]=new CurrentAccount(876);

        acc[1].deposit(10000);
        acc[2].deposit(12334);
        update(acc);

        acc2[1].deposit(14431);
        acc[2].deposit(1454321);
        closingAccounts(acc2[1]);

        Account acc3=new SavingsAccount(1241);
        Account acc4=new CurrentAccount(6743);
        openingAccounts(acc3);
        openingAccounts(acc4);

        dividendPays(acc[1]);

    }

    public static void update(Account[] acc3){
        for(Account acc: acc3){
            if(acc instanceof SavingsAccount){
                ((SavingsAccount) acc).addInterest(acc.getBalance());
                System.out.println(acc.toString());
            }
            else if(acc instanceof CurrentAccount){
                if(acc.getBalance()<=((CurrentAccount) acc).getOverDraft()){
                    System.out.println("Overdraft");
                }
            }
        }
    }


    public static void closingAccounts(Account acc){

            if(acc instanceof SavingsAccount){
                System.out.println("Closing Savings Account");
                acc.withdraw(acc.getBalance());
                System.out.println(acc.toString());
            }
            else if(acc instanceof CurrentAccount){
                System.out.println("Closing Curent Account");
                acc.withdraw(acc.getBalance());
                System.out.println(acc.toString());
            }
    }

    public static void openingAccounts(Account acc){

        if(acc instanceof SavingsAccount){
            System.out.println("Opening Savings Account");
            acc.getAccountNumber();
            System.out.println(acc.toString());
        }
        else if(acc instanceof CurrentAccount){
            System.out.println("Opening Curent Account");
            acc.getAccountNumber();
            System.out.println(acc.toString());
        }
    }


    public static void dividendPays(Account acc){
        if(acc instanceof SavingsAccount){
            acc.withdraw(1);
            System.out.println("Sum after dividend Savings"+acc.toString());
        }
        if(acc instanceof CurrentAccount){
            acc.withdraw(10);
            System.out.println("Sum after dividend Current"+acc.toString());
        }
    }



}
