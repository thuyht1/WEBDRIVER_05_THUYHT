package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_UserInteractions {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}


	@Test
	public void TC_01_MoveMouseToElement() throws Exception {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement hoverLink = driver.findElement(By.xpath("//a[text()='Hover over me']"));
		Actions action = new Actions(driver);
		
		action.moveToElement(hoverLink).perform();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tooltip-inner' and text()='Hooray!']")).isDisplayed());
			
	}

	@Test
	public void TC_02_ClickAndHoldElement() throws Exception {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List <WebElement> listNumbers = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions action = new Actions(driver);
		
		action.clickAndHold(listNumbers.get(0)).moveToElement(listNumbers.get(3)).release().perform();
		
		List <WebElement> numberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		int number = numberSelected.size();
		Thread.sleep(3000);
		
		Assert.assertEquals(4, number);
	}
	
	@Test
	public void TC_021_ClickAndHold_Random() throws Exception {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List <WebElement> listNumbers = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).build().perform();
		listNumbers.get(0).click();
		listNumbers.get(2).click();
		listNumbers.get(4).click();
		listNumbers.get(6).click();
		action.keyUp(Keys.CONTROL).build().perform();
		
		List <WebElement> numberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		int number = numberSelected.size();
		Thread.sleep(3000);
		
		Assert.assertEquals(4, number);
	}
	@Test
	public void TC_03_DoubleClick() throws Exception {
		driver.get("http://www.seleniumlearn.com/double-click");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement doubleClickMe = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
		Actions action = new Actions(driver);
		
		action.doubleClick(doubleClickMe).perform();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("The Button was double-clicked.", alert.getText());
		alert.accept();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
