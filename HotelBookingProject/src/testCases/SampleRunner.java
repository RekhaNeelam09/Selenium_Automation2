package testCases;

import java.util.ArrayList;
import java.util.List;

public class SampleRunner 
{

	public static void main(String[] args) 
	{
		// Initializing the List<XmlSuite>
		TestNGRunner runner = new TestNGRunner(1);
		runner.createSuite("Booking Suite", false);
		
		//Create the Test - with Parameters
		System.out.println("***************** Create Booking Test - Apply Discount - pay@hotel *****************");
		runner.addTest("Create Booking Test - Apply Discount - pay@hotel ");
		runner.addTestParameter("action","pay@hotel");
		
		List<String> includeMethodNames = new ArrayList<String>();
		includeMethodNames.add("searchHotel");
		includeMethodNames.add("selectHotel");
		includeMethodNames.add("enterGuestInfo");
		runner.addTestClass("testCases.BookingSearch", includeMethodNames);
		
		includeMethodNames = new ArrayList<String>();
		includeMethodNames.add("applyDiscount");
		includeMethodNames.add("makePayment");
		runner.addTestClass("testCases.PaymentManagement", includeMethodNames);
		
		includeMethodNames = new ArrayList<String>();
		includeMethodNames.add("checkMail");
		includeMethodNames.add("checkMobile");
		runner.addTestClass("testCases.CustomerCommunications", includeMethodNames);
		
		//2nd Test
		System.out.println("*************** Create Booking Test - No Discount - pay@hotel ******************");
		runner.addTest("Create Booking Test - No Discount - pay@hotel");
		runner.addTestParameter("action", "pay@hotel");
		
		List<String> includeMethodNames1 = new ArrayList<String>();
		includeMethodNames1.add("searchHotel");
		includeMethodNames1.add("selectHotel");
		includeMethodNames1.add("enterGuestInfo");
		runner.addTestClass("testCases.BookingSearch", includeMethodNames1);
		
		includeMethodNames1 = new ArrayList<String>();
		includeMethodNames.add("makePayment");
		runner.addTestClass("testCases.PaymentManagement", includeMethodNames1);
		
		runner.run();
	}

}
