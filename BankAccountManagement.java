import java.util.*;
import java.util.ArrayList;


class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException (String name){
        super(name);
    }
}


class BankAccount
{
    private String accountName;
    private int accountId;
    private double accountBalance;
        public BankAccount(String accountName,int accountId){
            this.accountName=accountName;
            this.accountId=accountId;
            this.accountBalance=0.0;
        }
        public String getAccountName(){return accountName;}
        public int getAccountId(){return accountId;}
        public double getAccountBalance(){return accountBalance;}
        
        public void displayAccount(){
            System.out.println("Account Name  : "+accountName);
            System.out.println("Account Id  : "+accountId);
            System.out.println("Account Balance  : "+accountBalance);
        }
        public void withdraw(double amount) throws InsufficientBalanceException{ 
            if(accountBalance>=amount&&amount>0){
                 accountBalance-=amount;
                 System.out.println("You Withdraw  : "+amount);
                 System.out.println("Your Current Balance  : "+accountBalance);

            }
            else{
                throw new InsufficientBalanceException("Balance Insufficient");
                
            }
            
        }
        public void deposit(double amount){
            if(amount>0){
                accountBalance+=amount;
                System.out.println("You Deposited  : "+amount);
                System.out.println("Your Current Balance  : "+accountBalance);
            }
            else{
                System.out.println("Negative Amount");
            }
        }


}
public class BankAccountManagement
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,BankAccount> map = new HashMap<>();
        
        
        while(true){
            System.out.println("Enter 1 to add Account");
            System.out.println("Enter 2 to Deposite Amount");
            System.out.println("Enter 3 to Withdraw Amount");
            System.out.println("Enter 4 to Search Account");
            System.out.println("Enter 5 to View All Account details");
            System.out.println("Enter 6 to Sort Accounts");
            System.out.println("Enter 7 to Remove Account");
            System.out.println("Enter 8 to exit");
            try{
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                        sc.nextLine();
                        System.out.println("Enter Account Name");
                        String name = sc.nextLine();
                        System.out.println("Enter Account Id");
                        int id = sc.nextInt();
                        BankAccount a = new BankAccount(name, id);
                        if(map.containsKey(id)){
                            System.out.println("This Id Already exist");
                        }
                        else{
                        map.put(a.getAccountId(), a);
                        System.out.println("Account Added");
                        }
                    break;
                case 2: 
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                        else{
                            System.out.println("Enter Your Account Id to Deposite");
                            int searchid=sc.nextInt();
                            if(map.containsKey(searchid)){
                                System.out.println("Enter Amount to Deposite Amount");
                                double deAmount=sc.nextDouble();
                                BankAccount acc= map.get(searchid);
                                acc.deposit(deAmount);
                            }
                            else{
                                System.out.println("Account Not FOund ");
                            }
                        }
                        break;
                case 3 :
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                        else{
                            
                            System.out.println("Enter Your Account Id to withdraw");
                            int searchid=sc.nextInt();
                            if(map.containsKey(searchid)){
                                try{
                                System.out.println("Enter Amount to withdraw");
                                double wAmount = sc.nextDouble();
                                BankAccount acc = map.get(searchid);
                                acc.withdraw(wAmount);
                                }
                                catch(InsufficientBalanceException e){
                                    System.out.println(e.getMessage());
                                } 
                            }
                            else{
                                System.out.println("Account Not found");
                            }
                        
                        }
                    
                        break;
                case 4:
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                        else{
                            System.out.println("Enter Account Id to View details of Your Account");
                            int accId= sc.nextInt();
                            if(map.containsKey(accId)){
                                BankAccount acc = map.get(accId);
                                acc.displayAccount();
                            }
                            else{
                                System.out.println("Account Not Found");
                            }
                        }
                        break;
                case 5:
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                       else{ 
                        for(BankAccount b : map.values()){
                            b.displayAccount();
                        } 
                    }
                    break;
                case 6:
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                        else{
                            ArrayList<BankAccount>list = new ArrayList<>(map.values());
                            Collections.sort(list, Comparator.comparingInt(BankAccount :: getAccountId));
                            for(BankAccount b : list){
                                b.displayAccount();
                            }
                        }
                        break;
                case 7 :
                        if(map.isEmpty()){
                            System.out.println("No Accounts");
                        }
                        else{
                            System.out.println("Enter Account Id to Remove Account");
                            int accId = sc.nextInt();
                            if(map.containsKey(accId)){
                                BankAccount acc = map.remove(accId);
                                
                                System.out.println("Account Removed");
                            }
                            else{
                                System.out.println("Account Not Found");
                            }
                            
                        }
                        break;
                case 8:
                        System.out.println("You Exited");
                        return;
            
                default:
                        System.out.println("Invalid Input");
                    break;
                      }
                    }  catch(InputMismatchException e){
                            System.out.println("Invalid input");
                        sc.nextLine();
            }
            } 
        
           
        

    }
}