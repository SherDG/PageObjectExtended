package rough;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
	
//	private WebDriver driver;
//	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
//
//	public WebDriver getDriver() {
//		return dr.get();
//	}
//	
//	public void setWebDriver(WebDriver driver) {
//		dr.set(driver);
//	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username, String pass, String browser) throws InterruptedException, MalformedURLException {
		
//		if(browser.equals("chrome")) {
//			System.out.println("TC_1 browser: "+browser);
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
//		driver = new ChromeDriver();
//		} else if(browser.equals("firefox")) {
//			System.out.println("TC_1 browser: "+browser);
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//		setWebDriver(driver);
		openBrowser(browser);		
		getDriver().findElement(By.cssSelector("#user_login")).sendKeys(username);
		getDriver().findElement(By.cssSelector("#user_pass")).sendKeys(pass);
		getDriver().findElement(By.cssSelector("#wp-submit")).click();
		quit();
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://499.wordpress.imunify.local/wp-admin/");
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("#user_login")).sendKeys(username);
//		driver.findElement(By.cssSelector("#user_pass")).sendKeys(pass);
//		driver.findElement(By.cssSelector("#wp-submit")).click();
//		driver.quit();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		Object[][] data = new Object[2][3];
		data[0][0]="admin";
		data[0][1]="password1";
		data[0][2]="chrome";
		
		data[1][0]="admin";
		data[1][1]="password1";
		data[1][2]="firefox";
		
		return data;
	}
}
