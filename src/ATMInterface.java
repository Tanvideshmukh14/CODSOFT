import java.sql.SQLOutput;
import java.util.Scanner;

class UserBankAccount{
    private double bankBalance ;

    public UserBankAccount(){}

    public UserBankAccount(double bankBalance){
        this.bankBalance = bankBalance;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void depositAmount(double depositAmount){
        bankBalance = bankBalance + depositAmount;
    }

    public void withdrawAmount(double withdrawalAmount){
        if (withdrawalAmount <= bankBalance){
            bankBalance = bankBalance - withdrawalAmount;
            System.out.println("Cash is withdrawn successfully.");
            System.out.println("Available balance is Rs." + getBankBalance());

        }else {
            System.out.println("Insufficient balance");

        }
    }
}

class ATMMachine{
   private UserBankAccount userAccount;

   public ATMMachine(){
   }
   public ATMMachine(UserBankAccount userAccount){
       this.userAccount = userAccount;

   }
   public void displayOptions(){
       System.out.println("Welcome");
       System.out.println("Press 1 : Check Balance");
       System.out.println("Press 2 : Deposit Amount");
       System.out.println("Press 3 : Cash Withdrawal");
   }
   public void Options() {
       int option;
       double amount;
       Scanner Input = new Scanner(System.in);

       displayOptions();

       System.out.println("Choose one option");
       option = Input.nextInt();

       switch (option){
           case 1:
               System.out.println("Available balance : Rs." + userAccount.getBankBalance());
                break;
           case 2:
               System.out.println("Enter the amount to be deposited : ");
               amount = Input.nextInt();
               if (amount > 0){
                   userAccount.depositAmount(amount);
                   System.out.println("Your amount is deposited successfully.");
                   System.out.println("Available balance is Rs." + userAccount.getBankBalance());
               }
               break;
           case 3 :
               System.out.println("Enter the withdrawal amount : ");
               amount = Input.nextInt();
               userAccount.withdrawAmount(amount);
               break;
           default:
               System.out.println("Please choose a valid option and try again.");

       }
   }

}

public class ATMInterface {
    public static void main(String[] args) {
         UserBankAccount user = new UserBankAccount(7777777);
         ATMMachine atmMachine = new ATMMachine(user);
         atmMachine.Options();

    }
}
