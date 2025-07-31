package utilies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelper {
    WebDriver driver;
    WebDriverWait wait;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

    }
    
    public void click(By locator ) {
          wait.until(ExpectedConditions.elementToBeClickable(locator));
         driver.findElement(locator).click();
        }
    
    
    
    public void sendKeys(By locator,String text )
    {
          wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	 driver.findElement(locator).sendKeys(text);

    }
    
    public String getText(By locator )
    {
    	
          wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	return driver.findElement(locator).getText( );

    }
    
    
    

}
