package objectPage;


import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ObjectCalMo {
	
	WebDriver driver;
	
	public ObjectCalMo (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using ="Mortgage Calculator")
	WebElement mortgageLink;
	@FindBy(how = How.ID, using = "chouseprice")
	WebElement homePrice;
	@FindBy(how = How.NAME, using ="cdownpaymentunit")
	WebElement DPUnit;
	@FindBy(how = How.ID, using = "cdownpayment")
	WebElement DownPay;
	@FindBy(how = How.ID, using = "cloanterm")
	WebElement LaonTerm;
	@FindBy(how = How.ID, using = "cinterestrate")
	WebElement InterestRate;
	@FindBy(how = How.ID, using = "cstartmonth")
	WebElement startMonth;
	@FindBy(how = How.ID, using = "cstartyear")
	WebElement year;
	@FindBy(how = How.XPATH, using = "//input[@value='Calculate']")
	WebElement CalBtn;
	
	@FindBy(how=How.CLASS_NAME, using = "h2result")
	WebElement resultTxt;
	
	
	public void clearInputs() {
		homePrice.clear();
		DownPay.clear();
		LaonTerm.clear();
		InterestRate.clear();
		year.clear();
	}
	
	public void mortgageLinkSet() {
		mortgageLink.click();
	}
	
	public void homePriceSet(String Hprice) {
		homePrice.sendKeys(Hprice);
	}
	
	public void DPUnitSet(String unit) {
		DPUnit.click();
		Select unitList = new Select(DPUnit); 
		unitList.selectByValue(unit);
	}
	
	public void DownPaySet(String downPay) {
		DownPay.sendKeys(downPay);
	}
	
	public void LaonTermSet(String loanTerm) {
		LaonTerm.sendKeys(loanTerm);
	}
	
	public void InterestRateSet(String rate) {
		InterestRate.sendKeys(rate);
	}
	
	public void startMonthSet(String month) {
		startMonth.click();
		Select monthList = new Select(startMonth);
		monthList.selectByVisibleText(month);
	}
	
	public void yearSet(String yearTxt) {
		year.sendKeys(yearTxt);
	}
	
	public void CalBtnSet() {
		CalBtn.click();
	}
	
	
	public void resultTxtSet(double p, double d, double i, double n) {
		double mInt = (i/100)/12;
		double m = n * 12;
//		p-d = the total amount of loan
		
//		Mortgage = (P-d) [ i((1 + i)^n )] / [ ((1 + i)^n) – 1]
//		-------------------------------------------------
		double mortgage = ((p-d) * (mInt*(Math.pow((1 + mInt),m))) / ((Math.pow((1 + mInt),m )- 1))); 
		DecimalFormat df = new DecimalFormat("#,###.##");
		System.out.println("The Monthly Mortgage calculated manually is : $" + df.format(mortgage));
		
		String s = resultTxt.getText();
		System.out.println(resultTxt.getText());
		String str = s.substring(15);
		if (str.equals("$" + df.format(mortgage))) {
			System.out.println("The Test is passed Mostafa");
		}
		else {
			System.out.println("The Test is Failed.....!");
		}

	}

}
