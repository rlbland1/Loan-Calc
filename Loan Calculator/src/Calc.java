import java.util.Scanner;

public class Calc {
	public static void main(String[]args)
	{
		double p,i,t;	//principle, interest, loan term
		int c;			//choice
		int count = 1;	//number of estimates done in current session
		Loan L;
		boolean loop = true;
		Scanner s = new Scanner(System.in);
		while(loop){
		System.out.println("Enter the amount being borrowed (Pricipal)");
		p = s.nextDouble();
		System.out.println("Enter interest rate (%)");
		i = (s.nextDouble())/100;
		System.out.println("Enter the loan term (in years)");
		t = s.nextDouble(); 
		do
		{
			System.out.println("Are youmaking a down payment 0 = no, 1 = yes");
			c = s.nextInt();
			if(c == 0)
			{
				L = new Loan(p,i,t);
				System.out.println("Loan Estimate #" + count);
				System.out.println("Principal: " + p + "\nInterest: " + (i*100) +"%"
						+ "\n Loan Term: " + t + "years\nTotal: " + L.calcTotal()
						+ "\nMonlthy Payment: " + L.calcPay() + "\n Interest paid: " + (L.calcTotal() - p));
			}
			else if(c==1)
			{
				System.out.println("Enter down payment");
				double d = s.nextDouble();
				L = new Loan(p,i,t,d);
				System.out.println("Loan Estimate #" + count);
				System.out.println("Principal: " + p + "\nDown Payment: "+ d 
						+"\nInterest: " + (i*100) +"%" + "\n Loan Term: " + t 
						+ "years\nTotal: " + L.calcTotal() + "\nMonlthy Payment: " + L.calcPay()
						+ "\nInterest paid: " + (L.calcTotal() - p));
			}
		}while(c<0 || c>1);
		int z;
		do
		{
			System.out.println("Would you like to make another calculation\n1=yes\t0=no");
			z= s.nextInt();
			if(z==1)
				loop=true;
			else if(z==0)
				loop=false;
			else
				System.out.println("Invalid input");
		}while(z<0||z>1);
		}
		System.out.println("Have a nice day");
	}
}
