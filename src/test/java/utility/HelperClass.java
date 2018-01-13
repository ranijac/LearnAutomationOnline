package utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	public static String cpatureScreenshot(WebDriver driver,String screenshotName)
	{
	  TakesScreenshot ts=(TakesScreenshot)driver;

	  File src=ts.getScreenshotAs(OutputType.FILE);
	//  String destination="./Screenshots/+screenshotName+System.currentTimeMillis()+ ".png";
	   return screenshotName;
	}

}
