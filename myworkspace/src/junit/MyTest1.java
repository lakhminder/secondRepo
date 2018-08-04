package junit;

import test.Test;


import junit.framework.TestCase;

public class MyTest1 extends TestCase {

	/*protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}*/
	
	public void testExecuteTestCase()
	{
		Test test = new Test();
		test.testJunit1();
		assertEquals("1", test.testJunit1());
		//System.out.println("Testing Successful!!");
	}

}
