package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public WebDriver initializeBroswer() throws IOException {
		Properties prop = new Properties();
		FileInputStream dataFile = new FileInputStream("C:\\Users\\amitd\\Selenium-Workspace\\End2EndFramework\\src\\main\\java\\framework\\data.properties");
		prop.load(dataFile);
		
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Softwares\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			//**Added comments to check GitHub
			System.setProperty("webdriver.ie.driver","C:\\Softwares\\Drivers\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		int timeout = Integer.parseInt(prop.getProperty("timeout"));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		return driver;
	}
}
