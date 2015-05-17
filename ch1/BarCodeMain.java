package bigjava.ch1;

/**
 * 
 * @author Josh Rhoads
 *
 */

public class BarCodeMain {

	public static void main(String[] args) {

		MailCode m1 = new MailCode( new ZipCode(16046) );
		System.out.print(m1);
 
		System.out.println();
		
		MailCode m2 = new MailCode( m1.getBarCode() );
		System.out.println(m2);
 
		if(m1.equals(m2)){ System.out.println("pass"); }
		else{              System.out.println("fail"); }

	}

}
