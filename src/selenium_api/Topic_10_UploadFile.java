package selenium_api;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

public class Topic_10_UploadFile {
	WebDriver driver;
	//Get auto directory
	String workingDirectory = System.getProperty("user.dir");
	String fileName= "uploadfile.jpg";
	String filePath= workingDirectory + "\\images\\" + fileName;
	String folderName = "Auto Test" + randomNumber();
	String email = "kimthuy.ht106" + randomNumber() + "@gmail.com";
	String name = "Automation testing";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		System.out.println(workingDirectory);
		System.out.println(filePath);
	}

	public void TC_01_SendKeys_API() throws Exception {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//input[@name='files[]']"));
		element.sendKeys(filePath);
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
	
	}

	public void TC_02_UploadFile_autoIT() throws Exception {
		
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.cssSelector(".fileinput-button"));
		element.click();
		
		Runtime.getRuntime().exec(new String[] {".\\autoIT\\chrome.exe", filePath});
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
	}

	
public void TC_03_UploadFile_Robot() throws Exception {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Specify the file location with extension
		StringSelection select = new StringSelection(filePath);
		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		WebElement element = driver.findElement(By.cssSelector(".fileinput-button"));
		element.click();
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		
		// Nhan phim xuong ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		//Nha phim ENTER
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		// Nhan phim Ctrl V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		
	}
	
@Test
	public void TC_04_Complex() throws Exception {
		driver.get("https://encodable.com/uploaddemo/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='uploadname1']"));
		uploadFile.sendKeys(filePath);
		
		WebElement folderTextbox = driver.findElement(By.xpath("//input[@id='newsubdir1']"));
		folderTextbox.sendKeys(folderName);
		
		WebElement emailTexbox = driver.findElement(By.xpath("//input[@id='formfield-email_address']"));
		emailTexbox.sendKeys(email);
		
		WebElement firstNameTextbox = driver.findElement(By.xpath("//input[@id='formfield-first_name']"));
		firstNameTextbox.sendKeys(name);
		
		WebElement beginUploadButton = driver.findElement(By.xpath("//input[@id='uploadbutton']"));
		beginUploadButton.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//dd[text()='Email Address: "+ email +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dd[text()='First Name: "+ name +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dt[contains(text(),'File 1 of 1')]/a[text()='"+ fileName +"']")).isDisplayed());
	
		WebElement viewUploadFile = driver.findElement(By.xpath("//a[text()='View Uploaded Files']"));
		viewUploadFile.click();
		
		WebElement folderNameLabel = driver.findElement(By.xpath("//a[text()='" + folderName +"']"));
		Assert.assertTrue(folderNameLabel.isDisplayed());
		folderNameLabel.click();
		
		WebElement imageUploaded = driver.findElement(By.xpath("//img[contains(@src,'" + fileName +"')]"));
		Assert.assertTrue(imageUploaded.isDisplayed());		
}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}
}