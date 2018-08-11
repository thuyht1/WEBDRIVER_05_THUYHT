package selenium_api;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_09_WebDriverWait {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();	
		
		wait = new WebDriverWait(driver, 30);
	}

	public void TC_01_ImplicitWait() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement buttonStart = driver.findElement(By.xpath("//*[@id='start']/button"));
		buttonStart.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}
	
	
	public void TC_02_ExplicitWait() {
	driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement dateTimePicker = driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_Panel1']"));
	wait.until(ExpectedConditions.visibilityOf(dateTimePicker));
	
	WebElement dateSelectedBefore = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));
	String textBefore = dateSelectedBefore.getText().trim();
	System.out.println(textBefore);
	Assert.assertEquals("No Selected Dates to display.", textBefore);
	
	WebElement today = driver.findElement(By.xpath("//a[text()='16']"));
	today.click();
	
	By ajaxIcon = By.xpath("//div[@class='raDiv']");
	wait.until(ExpectedConditions.invisibilityOfElementLocated(ajaxIcon));
	
	WebElement todaySelected = driver.findElement(By.xpath("//td[@class='rcSelected']/a[text()='16']"));
	wait.until(ExpectedConditions.visibilityOf(todaySelected));
	
	WebElement dateSelectedAfter = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));
	String textAfter = dateSelectedAfter.getText().trim();
	System.out.println(textAfter);
	Assert.assertEquals("Thursday, August 16, 2018", textAfter);
			
	}
	
	@Test
	public void TC_03_Fluent() {
	driver.get("https://stuntcoders.com/snippets/javascript-countdown/");	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement countdount = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
	wait.until(ExpectedConditions.visibilityOf(countdount));
	
	//khoi tao Fluent wait
	new FluentWait<WebElement>(countdount)
	//Tong time
	.withTimeout(15, TimeUnit.SECONDS)
	//Tan so time
	.pollingEvery(1, TimeUnit.SECONDS)
	// Gap exeception bo qua
	.ignoring(NoSuchElementException.class)
	//Dieu kien
	.until(new Function<WebElement, Boolean>() {
		public Boolean apply(WebElement element) {
			boolean flag = element.getText().endsWith("00");
			System.out.println("Time = " + element.getText());
			return flag;
		}	
	});
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}