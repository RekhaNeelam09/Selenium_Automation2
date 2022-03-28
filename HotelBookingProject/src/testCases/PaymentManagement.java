package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManagement { 

@Test
  public void applyDiscount() 
  {
	  System.out.println("applyDiscount");
  }

  @Parameters({"action"})
  @Test
  public void makePayment(String paymentType, ITestContext context) 
  {
	if(paymentType.equals("instantpayment"))
		
	  System.out.println("Instant Payment");
	  
	else
	
		System.out.println("Pay@Hotel");
	
	String bookingId = "Rekha@123";
	context.setAttribute("bID",bookingId);
  }

}
