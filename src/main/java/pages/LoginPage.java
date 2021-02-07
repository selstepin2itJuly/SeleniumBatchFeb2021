package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr; 
	
	//constructor
	public LoginPage(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(dr, this);//important to initialize elements
	}
	//Element with Locator
	@FindBy(id="txtUsername")
	private WebElement user;
	
	@FindBy(name="txtPassword")
	private WebElement pass;
	
	@FindBy(css="[value='LOGIN']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[@id='logInPanelHeading']")
	private WebElement loginPanelText;
	
	
	//methods
	public void loginToApp(String sText, String pText)
	{
		user.clear();
		user.sendKeys(sText);
		pass.clear();
		pass.sendKeys(pText);
		loginButton.click();
	}
	
	public String getLoginPanelText()
	{
		return loginPanelText.getText();
	}
	
	
}
