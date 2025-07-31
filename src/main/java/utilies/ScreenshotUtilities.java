package utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
public class ScreenshotUtilities {
	   public static void takeScreenShot(WebDriver driver,ITestResult result) throws IOException{
 

 
	        if (ITestResult.FAILURE == result.getStatus()) {
 	               String fileName = result.getName() + "_" + ".png";
	               File filePath = new File("./Screenshots/" + fileName);
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            if (filePath.exists()) {
	            	filePath.delete();
	            }

 	            FileUtils.copyFile(source, filePath);

	            try (FileInputStream inputStream = new FileInputStream(filePath)) {
 
	                Allure.addAttachment(result.getName() + " - Screenshot", "image/png", inputStream, ".png");
	            }
	        }
 
	    }


}
