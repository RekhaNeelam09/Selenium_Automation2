package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunications 
{
  @Test
  public void checkMobile(ITestContext context) 
  {
	  System.out.println("checkMobile");
	  String bookingID = (String)context.getAttribute("bID");
	  System.out.println("Your Confirmation BookingID is : "+bookingID);
  }
  
  @Test
  public void checkMail() 
  {
	  System.out.println("checkMail");
  }
}
