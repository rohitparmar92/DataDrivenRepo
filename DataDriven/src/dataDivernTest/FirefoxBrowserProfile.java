package dataDivernTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserProfile {

	public static void main(String[] args) {
	 String url = "http://www.letskodeit.com/";
	 WebDriver driver;
	 driver = new FirefoxDriver(); 
     driver.manage().window().maximize();
     driver.get(url);
	}

}
