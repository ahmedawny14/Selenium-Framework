package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilies.ScreenshotUtilities;


public class Listeners implements ITestListener{
	
	public static WebDriver driver;

	@Override
	public void onTestSuccess(ITestResult result) {
 	    System.out.println("✅ Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
           driver = BaseTest.driver;  
          // 
   		try {
			ScreenshotUtilities.takeScreenShot(driver, result);
		} catch (IOException e) {
 			e.printStackTrace();
		}


	    System.out.println("❌ Test Failed: " + result.getName());
	    
	}
	


}
