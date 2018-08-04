package junit;

import test.Test;


import junit.framework.TestCase;

public class MyTest3 extends TestCase {

	/*protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}*/
	
	public void testExecuteTestCase()
	{
		Test test = new Test();
		//test.testJunit1();
		assertEquals("3", test.testJunit3());
		//System.out.println("Testing Successful!!");
	}

}
