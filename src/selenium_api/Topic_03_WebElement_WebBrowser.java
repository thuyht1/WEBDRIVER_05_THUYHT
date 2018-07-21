package selenium_api;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_WebBrowser {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		// driver = new FirefoxDriver();

		// Chrome
		// System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// driver = new ChromeDriver();

		// IE
		System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		//System.setProperty("webdriver.ie.driver","driver path\\IEDriverServer.exe");
		//WebDriver driver=new InternetExplorerDriver();
		
		
		
		driver.get("http://daominhdam.890m.com/");

	}

	@Test
	public void TC_01_CheckElementDisplay() throws Exception {

		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
		Boolean EmailIsDisplayed = emailTextbox.isDisplayed();
		if (EmailIsDisplayed == true) {
			emailTextbox.sendKeys("Automation Testing");
		} else
			System.out.println("Email Textbox is disable");

		WebElement ageCheckbox = driver.findElement(By.xpath(".//input[@id='under_18']"));
		Boolean CheckedIsDisplayed = ageCheckbox.isDisplayed();
		if (CheckedIsDisplayed == true) {
			ageCheckbox.click();
		} else
			System.out.println("Age is disable");

		WebElement eduTextarea = driver.findElement(By.xpath(".//textarea[@id='edu']"));
		Boolean EduIsDisplayed = eduTextarea.isDisplayed();

		if (EduIsDisplayed == true) {
			eduTextarea.sendKeys("Automation Testing");
		} else
			System.out.println("Education textarea is disable");
	}

	@Test
	public void Test02_AnableElements() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String email = "//input[@id='mail']";
		if (isElementEnabled(driver, email)) {
			System.out.println("Textbox is enabled");
		} else {
			System.out.println("Textbox is disabled");
		}

		String radio_under18 = "//input[@id='under_18']";
		if (isElementEnabled(driver, radio_under18)) {
			System.out.println("Radio under18 button is enabled");
		} else {
			System.out.println("Radio under18 button is disabled");
		}

		String checkbox_dev = "//input[@id='development']";
		if (isElementEnabled(driver, checkbox_dev)) {
			System.out.println("Checkbox dev is enabled");
		} else {
			System.out.println("Checkbox dev is disabled");
		}

		String education = "//textarea[@id='edu']";
		if (isElementEnabled(driver, education)) {
			System.out.println("Text Area edu is enabled");
		} else {
			System.out.println("Text Area edu is disabled");

			String slider1 = "//*[@id='slider-1']";
			if (isElementEnabled(driver, slider1)) {
				System.out.println("Slider 1 is enabled");
			} else {
				System.out.println("Slider 1 is disabled");
			}

			String btn_anable = "//*[@id='button-enabled']";
			if (isElementEnabled(driver, btn_anable)) {
				System.out.println("Button 1 is enabled");
			} else {
				System.out.println("Button 1 is disabled");
			}

		}

		String job1 = "//select[@id='job1']";
		if (isElementEnabled(driver, job1)) {
			System.out.println("Dropdown List 1  is enabled");
		} else {
			System.out.println("Dropdown List 1 is disabled n");
		}
	}

	public boolean isElementEnabled(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@Test
	public void Test03_ElementIsDisabled() throws Exception {
		String pass = "//input[@id='password']";
		if (isElementEnabled(driver, pass)) {
			System.out.println("Password is enabled");
		} else {
			System.out.println("Password is disabled");
		}

		String radio_disable = "//input[@id='radio-disabled']";
		if (isElementEnabled(driver, radio_disable)) {
			System.out.println("Radio disable button is enabled");
		} else {
			System.out.println("Radio disable button is disabled");
		}

		String checkbox_dis = "//input[@id='button-disabled']";
		if (isElementEnabled(driver, checkbox_dis)) {
			System.out.println("Checkbox dis is enabled");
		} else {
			System.out.println("Checkbox dis is disabled");
		}

		String biography = "//textarea[@id='bio']";
		if (isElementEnabled(driver, biography)) {
			System.out.println("Text biography  Area is enabled");
		} else {
			System.out.println("Text  biography Area is disabled");

			String slider2 = "//*[@id='slider-2']";
			if (isElementEnabled(driver, slider2)) {
				System.out.println("Slider 2 is enabled");
			} else {
				System.out.println("Slider 2 is disabled");
			}

			String btn_dis = "//*[@id='button-disabled']";
			if (isElementEnabled(driver, btn_dis)) {
				System.out.println("Button dis is enabled");
			} else {
				System.out.println("Button dis is disabled");
			}

		}

		String job2 = "//select[@id='job2']";
		if (isElementEnabled(driver, job2)) {
			System.out.println("Dropdown List 2 is enabled");
		} else {
			System.out.println("Dropdown List 2  is disabled n");
		}
	}

	public boolean isElementDisabled(WebDriver driver, String yourLocator) {
		try {
			WebElement locator1;
			locator1 = driver.findElement(By.xpath(yourLocator));
			return locator1.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}