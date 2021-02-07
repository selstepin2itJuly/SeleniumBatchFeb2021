package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class LoginFeatureTest {
	
  private WebDriver dr;
  private LoginPage lp;
  private DashboardPage dp;
  
  @Test(priority=1, description="Verify if Login Page opend")
  public void verifyLoginPageOpened() throws IOException 
  {
	  Reporter.log("\n verifyLoginPageOpened");
	  String str = lp.getLoginPanelText();
	  TestUtility.attachCaptureScreen();
	  assertEquals("LOGIN Panel", str.trim());;
  }

  @Test(priority=2, description="Verify successful Login")
  public void verifyLoginSuccess() throws IOException 
  {
	  Reporter.log("\n Login to Page");
	  lp.loginToApp(TestBase.username, TestBase.password);
	  boolean b=dp.isWelcomeMsgDisplayed();
	  TestUtility.attachCaptureScreen();
	  assertTrue(b);
	  Reporter.log("\n Login successful:"+b);
  }
  
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() 
  {
	  dr.quit();
  }

}
