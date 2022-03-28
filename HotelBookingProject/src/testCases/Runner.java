package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner 
{
   
	public static void main(String[] args) 
	{
		TestNG testng = new TestNG();

		XmlSuite suite = new XmlSuite();
		suite.setName("Suite One");
		
		List<XmlSuite> allsuites = new ArrayList<XmlSuite>();
		allsuites.add(suite);
		// adding suites to the testng using setXmlSuites() with the list of XmlSuites as here we are having 'allSuites'
		testng.setXmlSuites(allsuites);
		 
		//Giving the XmlTest under the suite, In this scenario , through declared reference variable 'suite'
		XmlTest test = new XmlTest(suite);
		test.setName("LoginTest");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("testCases.Login"));
		//The above list of classes must be added to the above mentioned test Hence the below statement : 
		test.setXmlClasses(classes);
		
		testng.run();

	}

}
