package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver dr;
	
	public DashboardPage(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(linkText="Welcome Paul")
	WebElement welcomeMsg;
	
	@FindBy(css="span.quickLinkText")
	List<WebElement> quickLaunch;
	
	@FindBy(css="td.legendLabel")
	List<WebElement> legend;
	
	public Boolean isWelcomeMsgDisplayed()
	{
		boolean b=false;
				
		try 
		{
			b=welcomeMsg.isDisplayed();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	public int getQuickLaunchCount()
	{
		return quickLaunch.size();
	}
	
	public List<String> getAllQuickLaunchOptionText()
	{
		List<String> list=new ArrayList<String>();
		for(WebElement s:quickLaunch)
		{
			list.add(s.getText());
		}
		return list;
	}
	public List<String> getLegendText()
	{
		List<String> list=new ArrayList<String>();
		for(WebElement s:legend)
		{
			list.add(s.getText());
		}
		return list;
	}
}
