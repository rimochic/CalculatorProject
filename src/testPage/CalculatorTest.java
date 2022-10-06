package testPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Data.CalculatorData;
import basePage.browserSetUp;
import objectPage.ObjectCalMo;

public class CalculatorTest extends browserSetUp{
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void launchBrowser(String browser, String app) {
		driver = setUp(browser, app);
	}
	
	
	
	@Test(priority=1)
	public void getTitleMort() {
		System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Mortgage Calculator");
	}
	
	
	@Test(priority=2, dataProvider ="MortgageData", dataProviderClass = CalculatorData.class)
	public void MortgageCal_TC2(String HP, String unit, String DP, String LT, String IR, String SM, String Y) throws InterruptedException {
		ObjectCalMo obj = new ObjectCalMo(driver);
		obj.clearInputs();
		Thread.sleep(2000);
		obj.homePriceSet(HP);
		obj.DPUnitSet(unit);
		obj.DownPaySet(DP);
		obj.LaonTermSet(LT);
		obj.InterestRateSet(IR);
		obj.startMonthSet(SM);
		obj.yearSet(Y);
		obj.CalBtnSet();
	}
	
	@Test(priority=3, dataProvider="MortgageData", dataProviderClass = CalculatorData.class)
	public void CalManual(String HP, String unit, String DP, String LT, String IR, String SM, String Y) {
		ObjectCalMo obj = new ObjectCalMo(driver);
		obj.resultTxtSet(Double.parseDouble(HP), Double.parseDouble(DP), Double.parseDouble(IR), Double.parseDouble(LT));
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	

}
