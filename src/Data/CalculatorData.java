package Data;

import org.testng.annotations.DataProvider;

public class CalculatorData {
	
	@DataProvider(name="MortgageData")
	public Object getData() {
		Object[][] data = {{"700000","d","80000","30","5.71","Jul","2022"}};
		return data;
	}

}
