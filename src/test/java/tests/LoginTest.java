package tests;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
 import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilies.ActionHelper;
import utilies.ConfigReader;
import utilies.ExcelUtilies;
import utilies.Log;

 
  
public class LoginTest extends BaseTest {
	LoginPage loginPage;
	@Test(dataProvider = "testData")
	public void login(String email, String password, String expectedResult) throws InterruptedException {
		Log.info("Starting login test...");
		loginPage = new LoginPage(driver);

		Log.info("Adding credentials...");
		loginPage.enterUserName(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		if (expectedResult.equals("success")) {
			Assert.assertEquals(loginPage.showCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		} else if (expectedResult.equals("failure")) {
			Assert.assertEquals(loginPage.showErrorMessage(), "error");
		}
	}

	@DataProvider
	public Object testData() throws InvalidFormatException, IOException {

		Object data = ExcelUtilies.getDataFromExcel(
				ConfigReader.get("excelPath"),ConfigReader.get("excelSheet"));
		return data;
	}

}
