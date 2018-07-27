package selenium_api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Button_RadioButton {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Button() {
		driver.get("http://live.guru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account'] ")).click();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/login/", driver.getCurrentUrl());

		WebElement createAnAccountButton = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		clickElementByJavascript(createAnAccountButton);

		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/create/", driver.getCurrentUrl());
	}

	@Test
	public void TC_02_RadioButton() {
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");

		WebElement dualZoneRadio = driver
				.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
		clickElementByJavascript(dualZoneRadio);

		Assert.assertTrue(dualZoneRadio.isSelected());
		uncheckTheCheckbox(dualZoneRadio);

	}

	@Test
	public void TC_03_Checkbox() {

	}

	@Test
	public void TC_04_AcceptAlert() {
		driver.get("http://daominhdam.890m.com/");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals("You clicked an alert successfully", resultText.getText());

	}

	@Test
	public void TC_05_CancelAlert() {
		driver.get("http://daominhdam.890m.com/#");

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals("You clicked: Cancel", resultText.getText());
	}

	@Test
	public void TC_06_PromptAlert() {
		driver.get("http://daominhdam.890m.com/#");
		String name = "Automation Testing";

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();

		WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals("You entered: " + name, resultText.getText());
	}

	public void clickElementByJavascript(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public void uncheckTheCheckbox(WebElement element) {
		if (element.isSelected()) {
			JavascriptExecutor je =(JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", element);
			//element.click();
			Assert.assertTrue(!element.isSelected());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
