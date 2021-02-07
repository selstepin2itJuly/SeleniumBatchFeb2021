package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static String screenshotPath;
	public static String username;
	public static String password;
	
	public static WebDriver getInstance() throws IOException
	{
		String configFile="./src/main/java/config/config.properties";
		FileInputStream inStream=new FileInputStream(configFile);
		prop=new Properties();
		prop.load(inStream);
		browser=prop.getProperty("browser");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		
		screenshotPath=prop.getProperty("screenshot");
		//Cross browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeAgent"));
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxAgent"));
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("EdgeAgent"));
			driver=new EdgeDriver();
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEAgent"));
			InternetExplorerOptions opt= new InternetExplorerOptions();
			opt.ignoreZoomSettings();
			opt.disableNativeEvents();
			opt.enablePersistentHovering();
			opt.introduceFlakinessByIgnoringSecurityDomains();
			driver=new InternetExplorerDriver(opt);
		}else
		{
			Throwable th=new Throwable();
			th.initCause(null);
		}
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}

}
