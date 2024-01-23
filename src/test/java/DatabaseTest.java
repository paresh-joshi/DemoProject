import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DatabaseTest {
	CustomerDetails c = new CustomerDetails();
	
	@Test
	public void postJira() {
		
		System.out.println("POSTJIRA");
		}
	
	@Test
	public void deleteEntry() {
		
		System.out.println("DeleteEntry");
		
		Assert.assertEquals("Appium", "Appium");
		}

}
