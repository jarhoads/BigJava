package bigjava.ch1;

/**
 * 
 * @author Josh Rhoads
 *
 */

public class MailCode{
	 
	public static final int ZIP_CODE_SIZE = 5;
	public static final String[] BAR_CODE_VALUES =
		// 0        1        2       3      4       5       6      7       8       9
		{"::::|",":::||","::|:|","::|||",":|:::",":|:||",":||::","|::::","|::||","|:|::"};
 
	private BarCode bar;
	private ZipCode zip;
	
	/**
	 * Constructs MailCode given a zip code
	 * @param z zip code used to construct the MailCode
	 */	
	MailCode(ZipCode z){
		zip = z;
		bar = new BarCode(zip);
	}
	
	/**
	 * Constructs MailCode given a bar code 
	 * @param b bar code value for the BarCode
	 */
	MailCode(BarCode b){
		bar = b;
		zip = new ZipCode(bar);
	}
	/**
	 * Constructs MailCode given a bar code and zip code
	 * @param b bar code value for the BarCode
	 * @param z zip code value for the ZipCode
	 */ 
	MailCode(BarCode b, ZipCode z){
		bar = b;
		zip = z;
	}
	
	/**
	 * gets the BarCode
	 * @return a BarCode
	 */  
	public BarCode getBarCode(){ return bar; }
	
	/**
	 * gets the ZipCode
	 * @return a ZipCode
	 */  
	public ZipCode getZipCode(){ return zip; }
 
	/**
	 * override of equals
	 * @override 
	 * @param other MailCode of other object
	 */  
	public boolean equals(MailCode other){
		if(zip == null && bar == null){ return true; }
		else if(zip == null){ return bar.equals( other.bar ); }
		else if(bar == null){ return zip.equals( other.zip ); }
		else{ 
			                  return bar.equals( other.bar ) && 
		                             zip.equals( other.zip );   
		}
	}
	
	public String toString(){
		if(zip == null && bar == null){ return "No Mail Code"; }
		else if(zip == null){ return "Zip Code :      " + " - Bar Code : " + bar; }
		else if(bar == null){ return "Zip Code : " + zip + " - Bar Code : "; }
		else { return "Zip Code : " + zip + " - Bar Code : " + bar; }
	}
 
	public static void main(String[] args){
 
		MailCode m1 = new MailCode( new ZipCode(16046) );
		System.out.println(m1);
 
		MailCode m2 = new MailCode( m1.getBarCode() );
		System.out.println(m2);
 
		if(m1.equals(m2)){ System.out.println("pass"); }
		else{ System.out.println("fail"); }
	}
}