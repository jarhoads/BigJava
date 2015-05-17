package bigjava.ch1;
/**
 * 
 * @author Josh Rhoads
 *
 */

public class BarCode{
	 
	private String bar;
 
	/**
	 * Constructs BarCode given a bar code of type String
	 * @param bc car code value for the BarCode
	 */
	BarCode(String bc){ bar = bc; }
	 
	/**
	 * Constructs BarCode given a ZipCode
	 * @param zc the zip code used to construct the bar code
	 */ 
	BarCode(ZipCode zc){ toBar(zc); }
 
	 
	public String toString(){ return bar; }
		
	public boolean equals(BarCode other){
			
		if(this == other){ return true; }
		if(other == null){ return false; }
			
		return this.bar.equals(other.bar); 
	}
	
	private String barValue(int a){ return MailCode.BAR_CODE_VALUES[a]; }
 
	private int checkDigit(int[] zVals){
		int sum = 0;
		for(int i : zVals){ sum += i; }

		int j = 0;
		while((10*j) < sum){ j++; }
		
		return ((10*j) - sum);
	}
 
	private void toBar(ZipCode z){
		
		int zip = z.getZipCode();
		int[] zipVals = new int[MailCode.ZIP_CODE_SIZE];

		
		StringBuilder bc = new StringBuilder();
		bc.append("|");
       
		for(int i = (MailCode.ZIP_CODE_SIZE-1); i >= 0; i--){
			zipVals[i] = zip % 10;
			zip = zip / 10;			
		}
		
		for(int zv : zipVals){ bc.append(barValue(zv));	}
 
		bc.append(barValue(checkDigit(zipVals)));
		
		bc.append("|");
 
		bar = bc.toString();
	
	}


	
}
