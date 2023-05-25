import java.util.*;


public class Atm_Srinjay {
    static int sum=200000;
    static int withdraw,deposit;
    static String[] his=new String[10];
    static int tr=0;
    static int Userid=12345;
    static String pasw="srin23";

    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
    System.out.println("******Welcome to Srinjay's ATM!!!******");

    System.out.println("Enter Your Userid:");
    int user_id=sc.nextInt();
    System.out.println("Enter your password:");
    String pass=sc.next();
    while (true){
    if(checkPass(user_id,pass)){
        System.out.println("User Succesfully logged in !");
        Bank();
        break;
    }
    else{
        System.out.println("You have entered the incorrect userid or password.");
    }
}
    }

    public static boolean checkPass(int u,String p){
        if ((u==Userid)&&(p.equals(pasw))){
            return true;
        }
        return false;
    }

    public static void Bank(){
        Scanner sc=new Scanner(System.in);
        while(true){

        System.out.println("Choose 1 for Withdraw.");
        System.out.println("Choose 2 for Deposit.");
        System.out.println("Choose 3 for Check Balance.");
        System.out.println("Choose 4 for Bank Transfer.");
        System.out.println("Choose 5 for Transaction history.");
        System.out.println("Choose 6 for Exit.");
        
        System.out.println("Enter your choice");
            int c = sc.nextInt();

            switch (c)
            {
                case 1:
                System.out.println("Enter the amount to be withdrawn:");
                int n= sc.nextInt();
                if(n<sum && n<100000){
                sum=sum-n;
                his[tr]="Withdrawn amount: "+n;
                tr++;
                System.out.println("Remaining Balance: "+sum);
                }
                else if(n>sum){
                    System.out.println("Insufficient Balance.");
                }
                else{
                    System.out.println("You cannot withdraw more than 100000 in one day.");
                }
                System.out.println("");  
                break;

                case 2:
                System.out.println("Enter the amount to be deposited:");
                int dep=sc.nextInt();
                System.out.println("Amount deposited Successfully !");
                if(dep<100000){
                sum=sum+dep;
                his[tr]="Amount deposited: "+dep;
                tr++;
                System.out.println("Your new balance is:"+sum);
                System.out.println("");  
                }
                else{
                    System.out.println("You cannot deposit more than 100000 in one day!");
                    System.out.println("");  
                }
                break;

                case 3:
                System.out.println("Your current amount left in your account:"+sum);
                System.out.println("");
                break;
                
                case 4:
                System.out.println("Enter if you want to transfer to a bank account or a phone number:");
                System.out.println("Enter 'b' for Bank transfer or 'p' for Phone transfer");
                char ch = sc.next().charAt(0);
                if(ch =='b'){
                    System.out.println("Enter the bank number:");
                    String bn=sc.next();
                    
                    
                    if(bn.length()>8 && bn.length() <19)
                    {
                        System.out.println("Enter the amount to be transferred:");
                        int amt=sc.nextInt();
                        if(amt<sum && amt<100000){
                        sum=sum-amt;
                        his[tr]="Transferred amount : "+amt;
                        tr++;
                        System.out.println("Amount transfered to bank account.");
                        System.out.println("Remaining Balance: "+sum);
                        System.out.println("");
                        }
                        else{
                            System.out.println("You do not have sufficient balance to transfer this amount.");
                        }
                    }
                    else{
                        System.out.println("Wrong bank account number.");
                    }
                }
                else if( ch=='p'){
                    System.out.println("Enter the phone number to which the money has to be sent:");
                    String pn=sc.next();
                    
                    if(pn.length()==10)
                    {
                        System.out.println("Enter the amount to be transferred:");
                        int amnt=sc.nextInt();
                        if(amnt<sum && amnt<100000){
                        sum=sum-amnt;
                        his[tr]="Transferred amount:"+amnt;
                        tr++;
                        System.out.println("Amount transfered to bank account.");
                        System.out.println("Remaining Balance: "+sum);
                        }
                        else{
                            System.out.println("You do not have sufficient balance to transfer this amount.");
                        }
                    }
                    else{
                        System.out.println("Wrong phone number entered.");
                }
            }
                else{
                    System.out.println("Wrong choice!");
                }
                System.out.println();
                break;

                case 5:
                if(his.length==0)
                {
                    System.out.println("No transaction done in this session.");
                }
                else{
                    System.out.println("Transactions done:");
                    for(int i=0;i<tr;i++){
                       System.out.println(his[i]); 
                    }
                    System.out.println("Remaining balance:"+sum);
                }
                break;

                case 6:
                System.out.println("Thank you for using the service.");
                System.exit(0);
                break;
            }
        }
    }
}
