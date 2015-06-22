package bigjava.ch10;

public class FirstDigitDistribution
{
    private int[] counters;

    public FirstDigitDistribution(){ counters = new int[10]; }

    /**
     Processes values from this sequence.
     @param seq the sequence from which to obtain the values
     @param valuesToProcess the number of values to process
    */
    public void process(Sequence seq, int valuesToProcess)
    {
        for (int i = 1; i <= valuesToProcess; i++)
        {
            if (seq.hasNext())
            {
                int value = seq.next();
                int firstDigit = getFirstDigit(value); 
                value = value % 10;
                counters[firstDigit]++;
            }
        }
    }

    private int getFirstDigit(int v)
    {
        int digit = v;
        while (Math.abs(digit) >= 10){ digit /= 10; }

        return digit;
    }

    /**
   Displays the counter values of this distribution.
*/
    public void display(){

      for (int i = 0; i < counters.length; i++){

         System.out.println(i + ": " + counters[i]);
      }

      String histogram = getHistogram();

      System.out.println(histogram);
   }

    private String getHistogram(){

      String hist = "";
 
      for(int i = 0; i < counters.length; i++){
         hist += (i + ": ");

         int size = counters[i];         
         for(int j = 0; j < size; j++){ hist += "*"; }

         hist += "\n";
         
      }

      return hist; 
   }
 
}
