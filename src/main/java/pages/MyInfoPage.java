package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private WebDriver dr;
	
	public MyInfoPage(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="a#menu_pim_viewMyDetails > b")
	WebElement myInfoTab; 
	
	@FindBy(css="div#profile-pic> h1")
	WebElement userName;
	
	@FindBy(xpath="//ul[@id='sidenav']/descendant::a")
	List<WebElement> sideMenu;
	
	public void gotoMyInfo()
	{
		myInfoTab.click();
	}
	
	public String getUsername()
	{
		return userName.getText().trim();
	}
	public List<String> getUserSideMenu()
	{
		List<String> str=new ArrayList<String>();
		for(WebElement s:sideMenu)
		{
			str.add(s.getText().trim());
		}
		return str;
	}
}
