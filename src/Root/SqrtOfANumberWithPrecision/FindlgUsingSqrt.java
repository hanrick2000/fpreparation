package Root.SqrtOfANumberWithPrecision;


/*
 * Question: Find log2 using sqrt (Facebook Question)
 * 
 * Question and Answer Source: http://stackoverflow.com/questions/5701023/finding-log2-using-sqrt
 * 
 * Algorithm:
 * Perhaps I have found the exact answers the interviewers were looking for. From my part, 
 * I would say it's little bit difficult to derive this under interview pressure. 
 * The idea is, say you want to find log2(13), you can know that it lies between 3 to 4. 
 * Also 3 = log2(8) and 4 = log2(16),

from properties of logarithm, we know that log( sqrt( (8*16) )  = (log(8) + log(16))/2 = (3+4)/2 = 3.5

Now, sqrt(8*16) = 11.3137 and log2(11.3137) = 3.5. Since 11.3137<13, we know that our desired log2(13) 
would lie between 3.5 and 4 and we proceed to locate that. It is easy to notice that this has a Binary 
Search solution and we iterate up to a point when our value converges to the value whose log2() we wish 
to find. Code is given below:
 */
public class FindlgUsingSqrt {
	public static void main(String[] args) {
		System.out.println(Log2(13));
	}
	public static double Log2(double val) // val = 13
	{
		// declaration
	    int low=0,high=0;                       // int
	    double highValue=0.0, lowValue=0.0;     // double
	    high = 0;
	    
	    // initialization
	    while((1<<high)<val)
	        high++;                     // highX = 4 and lowX = 3
	    low =high-1;
	    
	    
	    double midValue = (double)0;   
	    lowValue = (1<<low) ;          // leftValue=8 (2^3)
	    highValue = (1<<high);         // rightValue=16 (2^4)
	    
	    double lowD = (double)low;            // change all integers to double
	    double highD = (double)high;
	    double midD = (double)0;
	    
	    while(Math.abs(lowValue-val)>1e-10)
	    {
	        midD = (lowD+highD)/2;
	        
	        midValue = Math.sqrt(lowValue*highValue);

	        if ( midValue > val)
	        {
	             highD = midD;
	             highValue = midValue;
	        }
	        else{
	            lowD=midD;
	            lowValue = midValue;
	        }
	    }
	    return lowD;

	}
}
