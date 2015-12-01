
public class Loan {
	private double principal, interest, total; 
	private double downPay = 0;				//default down payment =0
	private double loanTerm;				//loan duration in years
	private int payRate = 12;				//default interest compounds monthly
	public Loan(double principal, double interest, double loanTerm)
	{
		this.principal = principal;
		this.interest = interest;
		this.loanTerm = loanTerm;
	}
	
	public Loan(double principal, double interest, double loanTerm, double downPay)
	{
		this.principal = principal;
		this.interest = interest;
		this.loanTerm = loanTerm;
		this.downPay = downPay;
	}
	
	public double calcTotal()
	{
		double r = interest/payRate;
		double num = loanTerm*payRate;	//loan term in months
		total = ((principal-downPay)*r*(Math.pow(1+r,num)))/((Math.pow(1+r, num)-1))+principal;
		return total;
	}
	
	public double calcPay()
	{
		double actualPay = total/(loanTerm*12);
		return actualPay;
	}
}
