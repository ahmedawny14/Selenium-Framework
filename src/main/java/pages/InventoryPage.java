package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

	private WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;

	}

	By selectedItems = By.xpath("//*[@id=\"item_1_img_link\"]/img");
	By itemDetailsTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
	By addToCartForbackpackItem = By.id("add-to-cart-sauce-labs-backpack");
	By addToCartBForBoltTshirtItem = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By removeButton = By.id("remove-sauce-labs-bolt-t-shirt");
	By cartBadge = By.className("shopping_cart_link");
	By filterDropDown = By.className("product_sort_container");
	By itemPrice = By.className("inventory_item_price");
	
	

	public void selectItem() {
		driver.findElement(selectedItems).click();

	}

	public String showItemTitle() {
		return driver.findElement(itemDetailsTitle).getText();
	}

	public void setAddToCartForbackpackItem() {
		driver.findElement(addToCartForbackpackItem).click();
	}

	public Boolean AddToCartBForBoltTshirtButton() {
		return driver.findElement(addToCartBForBoltTshirtItem).isDisplayed();
	}

	public void setAddToCartBForBoltTshirtItem() {
		driver.findElement(addToCartBForBoltTshirtItem).click();
	}

	public void clickOnRemoveButton() {
		driver.findElement(removeButton).click();
	}

	public String showCartBadgeCount() {
		return driver.findElement(cartBadge).getText();

	}

	public WebElement selectFilter() {
		return driver.findElement(filterDropDown);
	}

	public String showItemPrice() {

		return driver.findElement(itemPrice).getText();
	}

}
