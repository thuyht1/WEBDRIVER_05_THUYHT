package selenium_api;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Iframe_Windows {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Iframe_Frame() {
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Element not display
		/*
		 * List<WebElement> iframeClosePopup = driver
		 * .findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		 * System.out.println("Count element = " + iframeClosePopup.size());
		 * 
		 * if (iframeClosePopup.size() > 0) {
		 * driver.switchTo().frame(iframeClosePopup.get(0));
		 * 
		 * WebElement closePopup =
		 * driver.findElement(By.xpath("//div[@id='div-close'")); closePopup.click();
		 * 
		 * }
		 */

		WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		driver.switchTo().frame(lookingForIframe);

		WebElement lookingForElement = driver.findElement(By.xpath("//span[@id='messageText']"));
		String lookingForText = lookingForElement.getText();
		Assert.assertEquals("What are you looking for?", lookingForText);

		// Switch to Parent page (Top Windows)
		driver.switchTo().defaultContent();

		WebElement bannerImageIframe = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
		driver.switchTo().frame(bannerImageIframe);

		List<WebElement> images = driver.findElements(By.xpath("//div[@id='bannercontainer']//img"));
		int imageNumber = images.size();
		Assert.assertEquals(6, imageNumber);

		// Switch to Parent page (Top Windows)
		driver.switchTo().defaultContent();

		WebElement flipperBanner = driver.findElement(By.xpath("//div[@class='flipBanner']"));
		Assert.assertTrue(flipperBanner.isDisplayed());

		List<WebElement> flipperBannerImages = driver
				.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']"));
		imageNumber = flipperBannerImages.size();
		Assert.assertEquals(8, imageNumber);
	}

	@Test
	public void TC_02_OpenNewWindown() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		// Click your link
		String parentWindowID = driver.getWindowHandle();
		System.out.println("Parent ID = " + parentWindowID);

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		switchToChilWindow(parentWindowID);
		String googleTitle = driver.getTitle();

		Assert.assertEquals("Google", googleTitle);

	}

	// 2 window tab
	public void switchToChilWindow(String parent) {
		// Get all windows ID
		Set<String> allWindows = driver.getWindowHandles();
		// for - each
		for (String runWindow : allWindows) {
			System.out.println("Windows ID =" + runWindow);
			// Kiem tra ID nao ma khac parent ID thi switch qua
			if (!runWindow.equals(parent)) {
				// switch qa windows ID # parent ID
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	@Test
	public void TC_03_OpenNewWindown() {
		driver.get("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		List<WebElement> iframeClosePopup = driver
				.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		System.out.println("Count element = " + iframeClosePopup.size());

		if (iframeClosePopup.size() > 0) {
			driver.switchTo().frame(iframeClosePopup.get(0));

			WebElement closePopup = driver.findElement(By.xpath("//div[@id='div-close']"));
			closePopup.click();
		}

		String parentWindowID = driver.getWindowHandle();
		System.out.println("Parent ID = " + parentWindowID);

		driver.findElement(By.xpath("//a[text()='Agri']")).click();
		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");
		String AgriTitle = driver.getTitle();
		Assert.assertEquals("HDFC Bank Kisan Dhan Vikas e-Kendra", AgriTitle);

		driver.findElement(By.xpath("//p[text()='Account Details']")).click();
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		String accTitle = driver.getTitle();
		Assert.assertEquals("Welcome to HDFC Bank NetBanking", accTitle);

		// Click your link
		WebElement privacyPolicyFrame = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(privacyPolicyFrame);
		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		driver.switchTo().defaultContent();
		switchToWindowByTitle(
				"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		String privacyTitle = driver.getTitle();
		Assert.assertEquals(
				"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan",
				privacyTitle);

		// Click your link
		driver.findElement(By.xpath("//a[text()='CSR']")).click();
		switchToWindowByTitle("HDFC BANK - CSR - Homepage");
		String csrTitle = driver.getTitle();
		Assert.assertEquals("HDFC BANK - CSR - Homepage", csrTitle);

		switchToWindowByTitle("\"HDFC Bank: Personal Banking Services\"");

		closeAllWithoutParentWindows(parentWindowID);
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.hdfcbank.com/");
	}

	// <=2 window tab
	public void switchToWindowByTitle(String title) {
		// Get all windows ID
		Set<String> allWindows = driver.getWindowHandles();
		// Duyet qa tung ID
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			// Get title cua page do ra
			String currentTitle = driver.getTitle();
			// Title current windows = title truyen vao
			if (currentTitle.equals(title)) {
				break;
			}
		}

	}

	// Close all windows without parent window
	public boolean closeAllWithoutParentWindows(String parentWindow) {
		// Get all windown ID
		Set<String> allWindows = driver.getWindowHandles();
		// Duyet qua tung ID
		for (String runWindows : allWindows) {
			// Neu ID # parent ID
			if (!runWindows.equals(parentWindow)) {
				// switch qua id do
				driver.switchTo().window(runWindows);
				// Dong ID
				driver.close();
			}
		}
		// Switch qua parent Windows ID
		driver.switchTo().window(parentWindow);
		// Kiem tra no chi con lai 1 window (parent)
		if (driver.getWindowHandles().size() == 1)
			// return lai gia tri cho ham closeAllWithoutParentWindows
			return true;
		else
			return false;
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
