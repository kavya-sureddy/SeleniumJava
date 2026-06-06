package Exceptions;

public class ExceptionDemo {

	public static void main(String[] args) {
		
 int a = 10;
 int b = 0;
 
 try {
	 
	 int result = a/b;
	 
	 System.out.println("Result: " + result);
	 
 }catch (ArithmeticException e)
 {
	System.out.println("Error: You can't divide by Zero");
	System.out.println("Exception Details: " + e.getMessage());
	 
	 
 }
 
 finally{
	 System.out.println("Execution of Try Catch is Completed.");
 }
	
System.out.println("The Program continues"); 
	}

}
