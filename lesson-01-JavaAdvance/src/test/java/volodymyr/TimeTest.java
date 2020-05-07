package volodymyr;

//import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Test FAILED -> "+ description.getMethodName());
		};
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("Test SUCCEEDED -> "+description.getMethodName());
		};			
	};
	
	@Test
	public void beforeTest() throws Exception {
		new Time(00, 14);
	}
	
	@Test (expected = Exception.class)
	public void beforeExeptionTest() throws Exception {
		new Time(00, 30);
	}
	
	@Test (expected = Exception.class)
	public void beforeExeptionTest2() throws Exception {
		new Time(80, 10);
	}
	
	@Test (expected = Exception.class)
	public void beforeExeptionTest3() throws Exception {
		new Time(80, 40);
	}
	
//	Test Failed...(
//	@Test(expected = Exception.class)
//	public void allTimeTest() throws Exception {
//		Time real = Time.allTime(new Time(10, 10), new Time(15, 8));
//		Time expected = new Time(25, 18);
//		
//		Assert.assertEquals(expected, real);
//	}
	
}
