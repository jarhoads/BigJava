package bigjava.ch10;

public class PrimeSequence implements Sequence{
	  	
	private int n;

	PrimeSequence(){ n = 1; }
	
	public int next(){
	
		n++;
	    
		if(isPrime(n)){ return n; }
	    else{ 
	    	while(!isPrime(n)){ n++; }
	    	return n;
	    }
	}
	
	private boolean isPrime(int n){
		int nSquared = n * n;
	    
		for(int i=2; i<nSquared; i++){
	       if(n % i == 0){ return true; }
	    }
	    
	    return false;
    }
	
	public boolean hasNext(){ return true; }
}
