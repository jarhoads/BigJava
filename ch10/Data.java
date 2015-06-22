package bigjava.ch10;

public class Data{
	/**
	 * Computes the average of the measures of the given objects
	 * @param objects 
	 * @param meas
	 * @return
	 */
	public static double average(Object[] objects, Measurer meas){
		
		double sum = 0;
		
		for(Object obj : objects){
			sum = sum + meas.measure(obj); 
		}

		if(objects.length > 0){ return (sum / objects.length); }
		else{ return 0; }
	}
	
	public static double average(Object[] objects, Measurer meas, Filter f){
		
		double sum = 0;
		int total = 0;
		
		for(Object obj : objects){
			if(f.accept(obj)){ 
				sum = sum + meas.measure(obj);
				total++;
			}
		}

		if(total > 0){ return (sum / total); }
		else{ return 0; }
	}

}
