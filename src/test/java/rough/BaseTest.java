package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
//	private WebDriver driver;
//	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	//FOR GRID
	private RemoteWebDriver driver;
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	
	public WebDriver getDriver() {
		return dr.get();
	}
	
//	public void setWebDriver(WebDriver driver) {
//		dr.set(driver);
//	}
	
	//FOR GRID
	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
}
	
	public void openBrowser(String browser) throws InterruptedException, MalformedURLException {
//		if(browser.equals("chrome")) {
//			System.out.println("Browser is: "+browser);
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
//		driver = new ChromeDriver();
//		} else if(browser.equals("firefox")) {
//			System.out.println("Browser is:  "+browser);
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability(CapabilityType.PLATFORM, Platform.WIN8);           
//        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		
		
		//FOR GRID

		if(browser.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.PLATFORM, Platform.ANY);       
			options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);


		}else if(browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM, Platform.ANY);       
			options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			
		}
	
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("http://499.wordpress.imunify.local/wp-admin/");
		Thread.sleep(1500);
	}
	
	public void quit() {
		getDriver().quit();
	}
}
