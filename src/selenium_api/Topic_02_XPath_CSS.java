package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_XPath_CSS {
	WebDriver driver;
	private String email;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://live.guru99.com");
		
		//email = "kimthuy.ht106" + randomNumber() + "@gmail.com";
		
	}

	@Test
	public void TC_01_ChekURL() throws Exception {
		
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("Home page", homePageTitle);

		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);

		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/login/", loginUrl);
		Thread.sleep(3000);

		driver.navigate().forward();
		Thread.sleep(3000);

		String createAccountUrl = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/create/", createAccountUrl);

	}

	@Test
	public void TC_02_LoginEmpty() throws InterruptedException {
		
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//input[@id='pass']"));
		driver.findElement(By.xpath("//button[@name='send']")).click();

		String emailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", emailErrorMsg);

		String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("This is a required field.", passErrorMsg);

	}
	
	@Test 
	public void TC_03_InvalidEmail() throws InterruptedException {
		
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		//driver.findElement(By.xpath("//input[@id='pass']"));
		driver.findElement(By.xpath("//button[@name='send']")).click();

		String emailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", emailErrorMsg);

		String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("This is a required field.", passErrorMsg);
		
	}
	
	@Test 
	public void TC_04_IncorectPass() throws InterruptedException {
		
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@name='send']")).click();

		String emailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", emailErrorMsg);

		String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("This is a required field.", passErrorMsg);
		
	}

	@Test
	public void TC_05_CreateAccount() throws InterruptedException {
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Ho");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Kim");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Thuy");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("kimthuy.ht106" + ((int) (Math.random() * 100) + 1) + "@gmail.com");;
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='form-validate']/div[2]/button")).click();
		
		
		WebElement emailTxt = driver.findElement(By.xpath("//button[@id='email_address']"));
		emailTxt.sendKeys(email);
		
		String SuccesMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("Thank you for registering with Main Website Store.", SuccesMsg);
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	}

	/*public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}*/

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}