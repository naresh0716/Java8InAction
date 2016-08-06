package lambdasinaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test01Lambda {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01Lambda() {
		Runnable runnable = ()->System.out.println("From Runnable");
		Thread thread = new Thread(runnable);
		thread.start();
	}
	@Test
	public void test02FunctionalInterface(){
		Logger logger = LogManager.getLogger(Test01Lambda.class);
		Processor adder = (a,b) -> a+b;
		logger.info("Adding the numbers");
		int sum = adder.process(1, 2);
		Assert.assertEquals(3, sum, 0);
	}
}
@FunctionalInterface
interface Processor{
	int process(int a, int b);
}
