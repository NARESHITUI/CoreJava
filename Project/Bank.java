import java.util.Scanner;

class Bank 
{
 public static void main(String[] args) 
 {
  Account acc= null;  

  Scanner sc = new Scanner(System.in);

  while(true)
  {	  
  System.out.println("1.Create A/C");
  System.out.println("2.Deposit");
  System.out.println("3.Withdraw");
  System.out.println("4.Balance");
  System.out.println("5.Interest");
  System.out.println("6.Service Charge");
  System.out.println("7.Exit");

  System.out.print("enter an option[1-7]: ");
  int opt = sc.nextInt();
  System.out.println("------------------");

  switch(opt)
  {
   case 1: //create a/c
     if(acc == null){
     System.out.print("enter a/c type[1-SA/2-CA]: ");
	 int type=sc.nextInt();

	 if(type>2 || type<1){
      System.out.println("ERROR: Invalid A/C Type || Try Again!");
	 } //if
	 else
	 {
	 System.out.print("enter A/C number: ");
	 String acno = sc.next();
	 sc.nextLine();

	 System.out.print("enter name: ");
	 String name = sc.nextLine();

	 System.out.print("enter initial deposit: ");
	 float amt = sc.nextFloat();

     if(type==1){
	  System.out.print("enter ROI: ");
      float roi = sc.nextFloat();

	  /*to create Savings Account*/
      acc = new SavingsAccount(acno,name, amt, roi);
	 }//if
	 else{
     /* to create Current Account*/
	 acc =new CurrentAccount(acno, name,amt);
	}//else
	} //else
	} //if
	else{
     System.out.println("FYI: A/C is already created");
	}
    break;

   case 2: //deposit
    if(acc != null){
     System.out.print("enter amount to deposit: ");
	 float amt = sc.nextFloat();
	 acc.deposit(amt);
	}
	else{
     System.out.println("FYI: Create A/C First!");
	}
    break;

   case 3: //withdraw
    if(acc != null){
     System.out.print("enter amount to withdraw: ");
	 float amt = sc.nextFloat();
	 acc.withdraw(amt);
	}
	else{
     System.out.println("FYI: Create A/C First!");
	}
    break;

   case 4: //Balance
    if(acc != null){
     acc.getBalance(); 
	}
	else{
     System.out.println("FYI: Create A/C First!");
	}   
    break;

   case 5: //interest
    if(acc != null){
     /*check whether the a/c is of SavingsAccount type or not */
     if(acc instanceof SavingsAccount)
	 {
      ((SavingsAccount)acc).calculateInterest();
	 }
	 else
	 {
      //the a/c is of type Current Account
      System.out.println("ERROR: Interest is not applicable for this type of A/C");
	 }
	}
	else{
     System.out.println("FYI: Create A/C First!");
	}
    break;

   case 6: //service charge
    if(acc != null){
     if(acc instanceof CurrentAccount){
       ((CurrentAccount)acc).serviceCharge();
	 }
	 else{
      System.out.println("ERROR: Service change is not applicable for this type of A/C");
	 }
	}
	else{
     System.out.println("FYI: Create A/C First!");
	}
	break;

   case 7:
    System.out.println("** BYE BYE **");
    System.exit(0);
    break;

   default:
    System.out.println("Invalid Option.. Try Again");
    break;
  }//switch
  System.out.println("------------------");
  }//while
 } //main
}//class

