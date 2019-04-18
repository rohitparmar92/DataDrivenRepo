package dataDivernTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UsingExcelSheet {
private WebDriver driver;

	
	@BeforeClass
		public void setUp() throws Exception {
			
	driver = new ChromeDriver();
			
			
	// Maximize the browser's window
			
	driver.manage().window().maximize();
			
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	driver.get(Contstants.URL);
			
	driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
			
	// Tell the code about the location of Excel file
		
	ExcelUtility.setExcelFile(Contstants.File_Path + Contstants.File_Name, "LoginTests");
		}
		
		
	@DataProvider(name = "loginData")
		
	public Object[][] dataProvider() {
			
	Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
			
	return testData;
		}


	@Test(dataProvider="loginData")
		public void testUsingExcel(String username, String password) throws Exception {
			
	// Click login button
			
	driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
			
	Thread.sleep(2000);
			
	// Enter username
			
	driver.findElement(By.id("email")).sendKeys(username);
			
	// Enter password
			
	driver.findElement(By.id("password")).sendKeys(password);
			
	// Click Login button
			
	driver.findElement(By.name("hs-eu-confirmation-button")).click();
	Thread.sleep(2000);
	
	WebElement profile = driver.findElement(By.xpath("//*[@id=\"nav-profile\"]//div"));
	  profile.click();  
	  
	// Find if error messages exist
	boolean result = driver.findElements(By.xpath("//*[@id=\"mainRow\"]/div/div[2]/div/div/div[1]/div")).size() != 0;	
	Assert.assertTrue(result);
		}
		
	@AfterClass
	public void tearDown() throws Exception {
	   //driver.quit();	
	}
}
