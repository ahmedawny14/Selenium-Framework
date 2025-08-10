package base;

import java.io.IOException;
import org.testng.annotations.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilies.ConfigReader;
import utilies.Log;
  
 
public class BaseTest {

	public static   WebDriver driver;

	@BeforeMethod
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) {
        Log.info("Starting setup...");
        switch(browser.toLowerCase())
		{
		case "chrome": driver =new ChromeDriver(); break;
		case "firefox":driver =new  FirefoxDriver(); break;
 		default: System.out.println("No matching browser"); return;
		}
		driver.manage().window().maximize();
		 Log.info("Navigating to url...");
		 driver.get(ConfigReader.get("baseUrl"));
 
	}

	@AfterMethod
	public  void tearDown(ITestResult result) throws IOException {
        if (driver != null) {
            driver.quit();
        }
	}

}
