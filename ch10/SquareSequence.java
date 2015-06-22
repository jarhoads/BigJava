package bigjava.ch10;

public class SquareSequence implements Sequence
{
   private int n;

   public int next()
   {
      n++;
      return n * n; 
   }

    public boolean hasNext()
    {
        return true;
    }
}
