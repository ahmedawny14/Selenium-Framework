package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilies.ActionHelper;

public class LoginPage {

	private WebDriver driver;
    ActionHelper actionHelper;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.actionHelper = new ActionHelper(driver);
	}

	private By userName = By.id("user-name");
	private By pass = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");

	public void enterUserName(String username) {
     actionHelper.sendKeys(userName, username);	
}

	public void enterPassword(String password) {
		actionHelper.sendKeys(pass, password);
 	}

	public void clickOnLogin() {
		actionHelper.click(loginButton);
 	}

	public String showErrorMessage() {
		return actionHelper.getText(errorMessage);
	}
	
	
	public String showCurrentUrl()
	{
		
		return driver.getCurrentUrl();
	}

	 
	

}
