package rough;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin2 extends BaseTest{
	
	

	@Test(dataProvider="getData")
	public void doLogin(String username, String pass, String browser) throws InterruptedException, MalformedURLException {
		
//		if(browser.equals("chrome")) {
//			System.out.println("TC_2 browser: "+browser);
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
//		driver = new ChromeDriver();
//		} else if(browser.equals("firefox")) {
//			System.out.println("TC_2 browser: "+browser);
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		openBrowser(browser);		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("http://499.wordpress.imunify.local/wp-admin/");
		Thread.sleep(1500);
		getDriver().findElement(By.cssSelector("#user_login")).sendKeys(username);
		getDriver().findElement(By.cssSelector("#user_pass")).sendKeys(pass);
		getDriver().findElement(By.cssSelector("#wp-submit")).click();
		getDriver().quit();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		Object[][] data = new Object[1][3];
		data[0][0]="admin1";
		data[0][1]="password1";
		data[0][2]="firefox";
		
		
		return data;
	}
}
