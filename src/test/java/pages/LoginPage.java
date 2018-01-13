package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
    @FindBy(id="email") WebElement username;
    @FindBy(name="login[password]") WebElement password;
    @FindBy(xpath="//button[@id='send2'][@class='action login primary']") WebElement signIn;
    By signout=By.xpath("//div[@class='panel header']/child::ul/child::li[@class='customer-welcome']/child::div/child::ul/child::li[@class='authorization-link']/child::a");
    
    public void loginApplication(String user,String pass)
    {
    	username.sendKeys(user);
    	password.sendKeys(pass);
    	signIn.click();
    }
    public void verifySignOutLink()
    {
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));
    	//String text=ele.getText();
    	//Assert.assertEquals(text, "   Sign Out ","Sign Out Link not verified properly");
     
    } 
   
}
