package bigjava.ch10;

import java.awt.Rectangle;

public class MeasurerTester{
	
	public static void main(String[] args){
		
		Measurer areaMeas = new AreaMeasurer();
		
		Rectangle[] rects = new Rectangle[]{
				new Rectangle(5, 10, 20, 30),
				new Rectangle(10, 20, 30, 40),
				new Rectangle(20, 30, 5, 15)
		};
		
		double averageArea = Data.average(rects, areaMeas);
		System.out.println("Average area : " + averageArea);
		System.out.println("Expected     : 625");
		

		
		BankAccount[] accounts = new BankAccount[]{
				new BankAccount(100.00),
				new BankAccount(200.00),
				new BankAccount(300.00),
				new BankAccount(500.00),
				new BankAccount(1500.00),
				new BankAccount(2000.00)
		};

		Measurer accountMeas = new BankAccount();
		Filter accountFilter = new AccountFilter();
		
		double averageBalance = Data.average(accounts, accountMeas, accountFilter);
		
		System.out.println("average balance : " + averageBalance);
	}

}
