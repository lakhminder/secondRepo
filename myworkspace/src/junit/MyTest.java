package junit;

import junit.framework.TestCase;

public class MyTest extends TestCase {

	public void executeTestCase()
	{
		System.out.println("Testing Successful!!");
	}
	TestCase test= new MyTest();
	 test.run();

}
