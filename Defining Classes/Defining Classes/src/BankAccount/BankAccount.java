package BankAccount;

public class BankAccount {

  private static double defaultInterestRate = 0.02;
 private static int bankAccountCount = 1;
   private static double interestRate = defaultInterestRate;
   private int id;
   private double balance;

   public BankAccount(){
       this.id = bankAccountCount++;
   }

   public int getId(){
      return this.id;
   }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
        public double getInterestRate(int years){
       return this.balance * interestRate * years;
        }
       public  void deposit(int amount){
       this.balance += amount;
       }
}

