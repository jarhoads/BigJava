package bigjava.ch1;

/**
 * 
 * @author Josh Rhoads
 *
 */

public class ZipCode{
	 
	private int zip;
 
	ZipCode(int zc){ zip = zc; }
 
	ZipCode(BarCode bc){ toZip(bc); }
 
	public int getZipCode(){ return zip; }
 
	public String toString(){ return ""+zip; }
 
	private int barCharVal(char c){ return (c == ':') ? 0 : 1; }
 
	private int zipValue(String barCodeDigit){
 
		int zv = 0;
		zv = (7 * ( barCharVal(barCodeDigit.charAt(0)) )) +
		     (4 * ( barCharVal(barCodeDigit.charAt(1)) )) +
		     (2 * ( barCharVal(barCodeDigit.charAt(2)) )) +
		     (1 * ( barCharVal(barCodeDigit.charAt(3)) )) +
		     (0 * ( barCharVal(barCodeDigit.charAt(4)) )); 
 
		return zv;
	}
 
	private void toZip(BarCode b){
 
		String bar = b.toString();
		int zc = 0;
		zc = (10000 * zipValue(bar.substring(1,6))) +
		     (1000 * zipValue(bar.substring(6,11))) +
		     (100 * zipValue(bar.substring(11,16))) +
		     (10 * zipValue(bar.substring(16,21))) +
		     (zipValue(bar.substring(21,26)));
 
		zip = zc;
 
	}
	
	public boolean equals(ZipCode other){
		
		if(this == other){ return true; }
		if(other == null){ return false; }
		
		if(this.zip == other.zip){ return true; }
		else{ return false; }
	}
	
 
}
