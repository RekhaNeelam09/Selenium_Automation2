package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SimpleRunner 
{

	public static void main(String[] args) 
	{
		TestNG testng = new TestNG();
		
		XmlSuite mysuite = new XmlSuite();
		mysuite.setName("Booking Suite");
		
		List<XmlSuite> allsuites = new ArrayList<XmlSuite>();
		allsuites.add(mysuite);
		testng.setXmlSuites(allsuites);
		
		XmlTest createBookingTest = new XmlTest(mysuite);
		createBookingTest.setName("Create Booking Test - Apply Discount");
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("action", "pay@hotel");
		createBookingTest.setParameters(parameters);
		
		List<XmlClass> testClasses = new ArrayList<XmlClass>();
		
		XmlClass testClass = new XmlClass("testCases.BookingSearch");
		List<XmlInclude> methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("searchHotel",1));
		methods.add(new XmlInclude("selectHotel",2));
		methods.add(new XmlInclude("enterGuestInfo",3));
		testClasses.add(testClass);
		
		testClass =new XmlClass("testCases.PaymentManagement");
		methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("applyDiscount",1));
		methods.add(new XmlInclude("makePayment",2));
		testClasses.add(testClass);
		
		testClass = new XmlClass("testCases.CustomerCommunications");
		methods = new ArrayList<XmlInclude>();
		methods.add(new XmlInclude("checkMobile"));
		methods.add(new XmlInclude("checkMail"));
		testClasses.add(testClass);
		
		testng.run();
		
		
		

	}

}
