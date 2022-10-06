package testPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import basePage.browserSetUp;

public class HomePageTest extends browserSetUp{
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser", "url"})
	public void launchBrowser(String browser, String url) {
		driver = setUp(browser, url);
	}
	
	
	@Test
	public void getTitle() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
