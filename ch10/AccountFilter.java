package bigjava.ch10;

public class AccountFilter implements Filter{
	
	public boolean accept(Object o){
		
		BankAccount a = (BankAccount) o;
		
		return ( Double.compare(a.getBalance(), 1000.0) < 0 );
	}

}
