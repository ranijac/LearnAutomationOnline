package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver Idriver) {
		// assigned to a local driver
		this.driver = Idriver;

	}

	@FindBy(xpath = "html/body/div[1]/header/div[2]/div[1]/ul/li[2]/a")
	WebElement signInlink;
	@FindBy(xpath = "//a[text()='Create an Account']")
	WebElement accountLink;
	@FindBy(xpath ="//span[@class='counter qty']")
	WebElement myCart;

	public void clickOnSigninLink() {
		signInlink.click();
	}

	public void clickOnAccountLink() {
		accountLink.click();
	}

	public void clickOnmyCart() {
		myCart.click();
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}
}
