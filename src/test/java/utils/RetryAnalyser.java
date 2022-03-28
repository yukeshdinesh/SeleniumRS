package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import seleniumGrid.SeleniumGrid1;

public class RetryAnalyser  extends SeleniumGrid1 implements IRetryAnalyzer{
	
	int count=0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult result) {

		if(count<retryLimit) {
			count++;
			System.out.println("Retrying the Failed test "+result.getName());
			driver.close();
			
			return true;
		}
		return false;
	}

	
	
}
