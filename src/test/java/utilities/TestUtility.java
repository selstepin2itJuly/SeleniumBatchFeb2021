package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	//public static void captureScreen(WebDriver driver) throws IOException
	public static void captureScreen() throws IOException
	{
		Date dt=new Date();
		System.out.println(dt);
		SimpleDateFormat sdf=new SimpleDateFormat("Y_MMM_d_H_m_s_S");
		String str = sdf.format(dt);
		System.out.println(str);
		TakesScreenshot cs=(TakesScreenshot) driver;
		File file = cs.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(TestBase.screenshotPath+str+"_images.jpg"));
	}
	
	//public static void scrollToElement(WebDriver driver, WebElement ele)
	public static void scrollToElement(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
	}
	
	public static void attachCaptureScreen() throws IOException
	{
		TakesScreenshot cs=(TakesScreenshot) driver;
		String file = cs.getScreenshotAs(OutputType.BASE64);
		String st= "<img src=\"data:image/png;base64, " + file + "\" height=\"600\" width=\"800\" />";
		Reporter.log(st);
	}
}
