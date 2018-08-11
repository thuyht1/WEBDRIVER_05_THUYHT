package selenium_api;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Guid {
    WebDriver driver;
    
    
  //firefox <=47 + selenium version 2.x.x
  	// driver = new FirefoxDriver();
  		
  	//Firefox >= 48 + senium version 3.x.x
  	// System.setProperty("getdriver.gecko.driver", "\\driver\\geckodriver.exe");
  	// driver = new FirefoxDriver();
  		
  	// Chrome
  	//System.setProperty("webdriver.chrome.diver", ".\\driver\\chromedriver.exe");
  	//driver = new ChromeDriver();
  	
  	// IE 
  	// System.setProperty("webdriver.ie.diver", ".\\driver\\IEdriverServer.exe");
  	// driver = new InternetExplorerDriver();
    
    //format code: ctrl + shift + f
    
    // ctrl + shift + o: import library
    
	@Test
	public void TC_01() {
		
		//BROWSER cái tab mà nó đang đứngs
		
		
		// Close cái tab mà nó đang đứng
		driver.close();
		
		// close all tab + browser
		driver.quit();
		
		// open 1 URL
		driver.get("URL");
		
		// return url của page hiện tại
		String homePageUrl = driver.getCurrentUrl();
		
		//actual: business/requirement/spec 
		//expected : app will return this data.
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/login/", homePageUrl);
		
		//Get all source in page
		String sourceText =  driver.getPageSource();
		Assert.assertTrue(sourceText.contains(""));
		
		
		// Get title of current page
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("", homePageTitle);
		
		
		//Get GUID (Driver ID) of current page (parent)
		String homePageGUID = driver.getWindowHandle();
		
		//Return all GUID of all tabs
		Set <String> allWindowsID = driver.getWindowHandles();
		
		
		// Cookies Token
		// WebDRiver Wait (ổn định testcase)
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Zoom out browser
		driver.manage().window().maximize();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		//Alert
		driver.switchTo().alert();
		
		
		//Iframe/ frame
		driver.switchTo().frame(0);
		driver.switchTo().defaultContent(); //Parent page
		
		//WEB ELEMENT
		
		//driver = GUID
		//findElement: tìm đến element mình cần
		//By.xpath/ css/ id/ name/...: thông qua những locator mà nó support
		WebElement element = driver.findElement(By.xpath(""));
		// 	Không tìm thấy element: ném ra ngoại lê NoSuchElementException
		//	Tìm thấy duy nhất 1 element: Tương tác vs element đó
		//	Nhiều hơn 1 element: tương tác vs element đầu tiên
		
		// Clear data for element (textbox/text area/ -> nhap data)
		element.clear();
		
		// Nhap data for element (textbox/text area/ -> nhap data)
		element.sendKeys("");
		
		//Click vao 1 element (button/ checkbox/ radio/link...)
		element.click();
		
		String nameValue = element.getAttribute("value");
		
		
		element.getText();
		
		//get ra vi tri cua no trong resolution hien tai
		element.getLocation();
		
		// get ra chieu rong/ cao cua element
		element.getSize();
		
		// get gia tri cua css trong element do
		element.getCssValue("color");
		//#000
		element.getCssValue("font-size");
		// 14px
		
		WebElement tagname = driver.findElement(By.xpath("//inut[@name='name']"));
		String tag = tagname.getTagName();
		
		
		// For search/ login -> tuong tu nhu action: ENTER
		element.submit();
		
		
		List<WebElement> elements = driver.findElements(By.xpath("//a"));	
	
		// 	Không tìm thấy element: không ném ra ngoại lệ và trả về 1 list element rỗng
		//	Tìm thấy duy nhất 1 element: trả về 1 elemet
		//	Nhiều hơn 1 element: trả về 1 list elements (nhiều matching node)
		
		
		//ACTION: click/sendkey/select...
		// Kieu tra ve -> void
		
		// GET RA DATA: getCss/ getTagname/ getAttribute/ getTitle/ getCurrentUrl/...
		// (ngoai tru ham get(URL) -> gui thong tin len
		// kieu tra ve -> String
		
		//VERIFY DATA
		// kieu tra ve ->boolean
		// Assert.assertTrue(boolean) assertFalse(boolean)/ assertEquals(boolean)
		// actual, boolean expected)
		
		// Check 1 element co enable/disable tren page or not
		// pham vi ap dung: all element
		element.isDisplayed();
		
		// Check 1 element co hien thi tren trang page hay khong/ co visible (WebDriver Wait)
		// pham vi ap dung: all element
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		// Check 1 element duoc chon thanh khong or not
		// pham vi ap dung: checkbox/ radiobutton
		element.isSelected();
		
		
		// Dropdown: 1 thu vien rieng de support -> Check 1 element co duoc chon thanh cong or not
		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}