package dataDivernTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class SeleniumGrid_ParallelTest  {
	private WebDriver driver;
	private String baseUrl;
	private String nodeURL;
				
	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{	
	baseUrl = "https://www.fb.com/";		
	nodeURL = "http://192.168.43.5:4444/wd/hub";
	DesiredCapabilities caps = DesiredCapabilities.chrome();
			
	caps.setBrowserName("chrome");
			
	caps.setPlatform(Platform.WINDOWS);
			
	driver = new RemoteWebDriver(new URL(nodeURL), caps);		
	// Maximize the browser's window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void searchFlights() throws Exception {	
		driver.get(baseUrl);
	}
}