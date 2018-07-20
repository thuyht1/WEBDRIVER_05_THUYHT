package selenium_api;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_WebBrowser {
    WebDriver driver;
    
	@BeforeClass
	public void beforeClass() {
	
	//firefox <=47 + selenium version 2.x.x
	 driver = new FirefoxDriver();
		
	//Firefox >= 48 + senium version 3.x.x
	// System.setProperty("getdriver.gecko.driver", "\\driver\\geckodriver.exe");
	// driver = new FirefoxDriver();
		
	// Chrome
	//System.setProperty("webdriver.chrome.diver", ".\\driver\\chromedriver.exe");
	//driver = new ChromeDriver();
	
	// IE 
	// System.setProperty("webdriver.ie.diver", ".\\driver\\IEdriverServer.exe");
	// driver = new InternetExplorerDriver();
		
	}
		
	@Test
	public void TC_01_ChekURL() {
		driver.get("http://live.guru99.com");
		
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("Home page", homePageTitle);
		
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class ='footer']//a[text()='My Acount']"));
		myAccountLink.click();
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		driver.navigate().back();
		
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/login/", loginUrl);
		
		driver.navigate().forward();
		
		String createAccountUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/create/", createAccountUrl);
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}