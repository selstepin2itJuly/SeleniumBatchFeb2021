package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class DashboardTestcases {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	
  @Test(priority=3,description="Verify Quicl Launch count")
  public void VerifyQuickLaunchOptionsCount() throws IOException 
  {
	  Reporter.log("Total quick Launch options:"+dp.getQuickLaunchCount());
	  TestUtility.attachCaptureScreen();
	  assertEquals(6,dp.getQuickLaunchCount());
  }
  @Test(priority=2, description="Text of Quick Launch")
  public void VerifyQuickLaunchOptionsText() throws IOException 
  {
	  Reporter.log("\n Total quick Launch options:"+dp.getAllQuickLaunchOptionText());
	  TestUtility.attachCaptureScreen();
	  List<String> exp=new ArrayList<String>();
	  exp.add("Assign Leave");
	  exp.add("Leave List");
	  exp.add("Timesheets");
	  exp.add("Apply Leave");
	  exp.add("My Leave");
	  exp.add("My Timesheet");
	 // TestUtility.attachCaptureScreen();
	  assertEquals(dp.getAllQuickLaunchOptionText(), exp);
	  
  }
  
  @Test(priority=1,description="Verify Legend List on Application")
  public void VerifyLegendsList() throws IOException {
	  Reporter.log("\n Total quick Launch options:"+dp.getLegendText());
	  TestUtility.attachCaptureScreen();
	  List<String> exp=new ArrayList<String>();
	  exp.add("Not assigned to Subunits");
	  exp.add("Administration");
	  exp.add("Client Services");
	  exp.add("Engineering");
	  exp.add("Finance");
	  exp.add("Human Resources");
	  exp.add("Sales & Marketing");
	 // TestUtility.attachCaptureScreen();
	  assertEquals(dp.getLegendText(), exp);
  }
  
	/*
	 * @Test public void VerifyPendingLeaves() { }
	 * 
	 * @Test public void VerifyEmployeeDistributionbySubunit() { }
	 */
  @BeforeClass(alwaysRun=true)
  public void beforeClass() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  lp.loginToApp(TestBase.username, TestBase.password);
	  assertTrue(dp.isWelcomeMsgDisplayed());
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() 
  {
	  dr.quit();
  }

}
