package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class TestNGRunner 
{
	
	/*TestNG - complete TestNg
	 * XmlSuite - test Suite
	 * XmlTest - Test under a Suite
	 * XmlClass - Class under test
	 * XmlInclude - including Method under Class */
	
	TestNG testng;
	XmlSuite suite; // 1 suite
	List<XmlSuite> allSuites; //all the suites
	XmlTest test;//test case
	List<XmlTest> testCases; //all test cases under suite
	Map<String, String> testParameters;
	List<XmlClass> testClasses;
	
	public TestNGRunner(int suiteThreadPoolSize)
	{
		testng = new TestNG();
		allSuites = new ArrayList<XmlSuite>(); // All suite initialized empty
		testng.setXmlSuites(allSuites);
		testng.setSuiteThreadPoolSize(suiteThreadPoolSize);
	}
	
	public TestNGRunner() {
		// TODO Auto-generated constructor stub
	}

	public void createSuite(String suiteName,boolean parallelTest)
	{
		suite = new XmlSuite();
		suite.setName("suiteName");
	
		if(parallelTest)
		{
			suite.setParallel(ParallelMode.TESTS);
			allSuites.add(suite);
		}
	}
	
	public void addTest(String testName)
	{
		test = new XmlTest();
		test.setName(testName);
		testParameters = new HashMap<String,String>(); //Initializing test parameters Blank
		testClasses = new ArrayList<XmlClass>(); //empty test classes
		test.setParameters(testParameters); //blank-0 parameters
		test.setXmlClasses(testClasses); // blank-0 classes		
		
	}
	
	public void addTestParameter(String name,String value)
	{
		testParameters.put(name, value);
	}
	
	public void addTestClass(String className, List<String> includeMethodNames) 
	{
		XmlClass testClass = new XmlClass(className);
		List<XmlInclude> classMethods = new ArrayList<XmlInclude>();
		int priority = 1;
		for (String methodName: includeMethodNames)
		{
			XmlInclude method = new XmlInclude(methodName,priority);
			classMethods.add(method);
			priority++;
		}
		testClass.setIncludedMethods(classMethods);
		testClasses.add(testClass);
	}
	
	public void addListener(String ListenerFile)
	{
		suite.addListener("listener.MyTestNGListener");
	}
	
	public void run()
	{
		testng.run();
	}
	public static void main(String[] args)
	{
		

	}

}
