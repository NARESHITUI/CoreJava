class CurrentAccount extends Account 
{
 int transCount=0, allowedTrans=3;
 /*constructor*/
 CurrentAccount(String acno, String name, float bal)
 {
   super(acno, name, bal);
   System.out.println("Current A/C Created");
 }

 @Override
 void deposit(float amt){
  transCount++;
  super.deposit(amt);
 }

 @Override
 void withdraw(float amt)
 {
  transCount++;
  super.withdraw(amt);
 }
 
 @Override
 void getBalance(){
   transCount++;
   super.getBalance();
 }

 void serviceCharge()
 {
  /* get additional no of transactions from allowed trans*/

  int additionalTrans = this.transCount - this.allowedTrans;

  if(additionalTrans > 0)
  {
	  float scharge = additionalTrans * 100;
	  System.out.println("Service Charge of Rs."+scharge);
	  super.withdraw(scharge);
	  /*resetting the transCount */
	  this.transCount = 0;
  }
  else{
   System.out.println("No Service Charge required now!");
  }
 }
}
