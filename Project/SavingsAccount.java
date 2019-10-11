class SavingsAccount extends Account 
{
 float interest;

 /*constructor*/
 SavingsAccount(String acno, String name, float bal, float interest)
 {
	super(acno,name,bal); //calls super class constructor
	this.interest = interest;
	System.out.println("Savings A/C is created");
 }

 void calculateInterest()
 {
  float intrst = this.bal * this.interest / 100;

  System.out.println("Interest Amount of Rs." + intrst);
  this.deposit(intrst); //super.deposit(intrst); // deposit(intrst);
 }
}
