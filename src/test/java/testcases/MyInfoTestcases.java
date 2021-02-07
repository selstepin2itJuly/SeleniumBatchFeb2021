package testcases;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.TestBase;
import utilities.TestUtility;

public class MyInfoTestcases {
	  private WebDriver dr;
	  private LoginPage lp;
	  private DashboardPage dp;
	  private MyInfoPage infoP;
	  
	  @Test(priority=1,description="Verify Menu Option")
	  public void verifyUsersMenuOptions() throws IOException
	  {
		  Reporter.log("\n verify User Menu Options"+infoP.getUserSideMenu());
		  TestUtility.attachCaptureScreen();
		  List<String> expMenu=new ArrayList<String>();
		  expMenu.add("Personal Details"); expMenu.add("Contact Details"); 
		  expMenu.add("Emergency Contacts"); expMenu.add("Dependents"); 
		  expMenu.add("Immigration"); expMenu.add("Job");
		  expMenu.add("Salary"); expMenu.add("Tax Exemptions"); 
		  expMenu.add("Report-to");
		  expMenu.add("Qualifications"); expMenu.add("Memberships");
		  assertEquals(infoP.getUserSideMenu(), expMenu);
		  
	  }
	  
	  @Test(priority=2,dependsOnMethods="testTimeout", enabled=true, description="Verify User Name on My Info Tab")
	  public void verifyUserName() throws IOException
	  {
		  Reporter.log("\n verify User Name on My info"+infoP.getUsername());
		  TestUtility.attachCaptureScreen();
		  Assert.assertEquals(infoP.getUsername(), "Paul Collings");
		  
	  }
	  
	  @Test(priority=3,enabled=true, timeOut=4000, description="Verify timeout")
	  public void testTimeout() throws InterruptedException
	  {
		  Thread.sleep(5000);
	  }
	  @BeforeClass(alwaysRun=true)
	  public void beforeClass() throws IOException 
	  {
		  dr=TestBase.getInstance();
		  lp=new LoginPage(dr);
		  dp=new DashboardPage(dr);
		  infoP=new MyInfoPage(dr);
		  lp.loginToApp(TestBase.username, TestBase.password);
		  assertTrue(dp.isWelcomeMsgDisplayed());
		  infoP.gotoMyInfo();
	  }

	  @AfterClass (alwaysRun=true)
	  public void afterClass() {
		  dr.quit();
	  }
}
