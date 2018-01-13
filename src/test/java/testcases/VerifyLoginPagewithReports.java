package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPagewithReports {
	 WebDriver driver;
	 ExtentReports report;
	 ExtentTest logger;
	    @BeforeMethod
	    public void setUp()
	    {
	    	report=new ExtentReports("./Reports/LoginPageReport.html",true);
	    	logger=report.startTest("verify login");
	    	//logger=new ExtentTest("Verify Login Page","This Page will Verify Login");
	    	driver=BrowserFactory.getBrowser("chrome");
	    	driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	    	logger.log(LogStatus.INFO, "Application is up and running");
	    	
	    }
		@Test
		public void testHomePage() throws IOException {
			
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			String title = home.getApplicationTitle();
			Assert.assertTrue(title.contains("Ava"));
			logger.log(LogStatus.PASS, "Home Page loaded and verified");
			home.clickOnSigninLink();
			logger.log(LogStatus.INFO,"Click on Signin link");
			LoginPage login=PageFactory.initElements(driver, LoginPage.class);
			//login.loginApplication("ranijacob09@gmail.com","ranijacob09@gmail.com");
			login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
			logger.log(LogStatus.INFO,"Login to Application");
			
		}
		@AfterMethod
		public void tearDown()
		{
			BrowserFactory.closeBrowser(driver);
			report.endTest(logger);
			report.flush();
		}

}
