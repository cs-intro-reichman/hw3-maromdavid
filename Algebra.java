// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(10,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,-2));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-15,-3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for(int i = 0; i < x2; i++){
				x1 ++;
			}
			return x1;	
		}
		else{
			for(int i = 0; i > x2; x2++){
				x1 --;
			}
			return x1;	
		}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			for(int i = 0; i > x2; x2++)
		{
			x1 ++;
		}
		}
		else{
		for(int i = 0; i < x2; i++)
		{
			x1 --;
		}
	}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (x1 > 0 && x2 > 0) {
			for (int i = 0; i < x2; i++) {
				sum = plus(sum, x1);
			}
		}
		else if (x1 < 0 && x2 < 0) {
			for (int i = 0; i > x2; i--) {
				sum = minus(sum, x1);
			}
		}	
		else if(x1 < 0 && x2 > 0){
			for(int i = 0; i < x2; x2--) {
				sum = plus(sum, x1);
			}
		}
		else if(x1 > 0 && x2 < 0) {
				for(int i = 0; i < x1; i++) {
				sum = plus(sum, x2);
			}
		}
		return sum;
		}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = x;
		if(n == 0) {
			return 1;
		}
		for(int i = 1; i < n; i++)
		{
			sum = times(sum, x);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		if (x1 < 0 && x2 > 0){
			while(x1 < 0)
			{
				counter ++;
				x1 = plus(x1, x2);
			}
			return times(-1, counter);
		}
		else if (x1 > 0 && x2 > 0) {
			while(x1 >= x2)
			{
				counter ++;
				x1 = minus(x1, x2);
			}
		}
		else if(x1 < 0 && x2 < 0){
			x1 = minus(0, x1);
			x2 = minus(0, x2);
			while(x1 > 0) {
				counter ++;
				x1 = minus(x1, x2);
			}
		}


			
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while(x1 >= x2)
			{
				x1 = minus(x1, x2);
			}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int x1 = 0;
		int x2 = 0;
		while(x2 <= x)
		{
			x1 ++;
			x2 = times(x1, x1);
		}
		return minus(x1, 1);
	}	  	  
}