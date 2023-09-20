package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertion {
	WebDriver driver;

@BeforeTest
public void openApp() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	@Test
	public void facebookLoginTest() {
		driver.findElement(By.id("email")).sendKeys("Sumon");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Sumon123");
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		login.click();
			
}
	@Test
	public void assertion() {
		String actualTitle="Facebook - log in or sign up";
	    String expectedTitle =driver.getTitle();
	    
	    System.out.println("Expected home page title : "+expectedTitle);
	
		Assert.assertEquals(actualTitle, expectedTitle);
		
		String actualURL="https://www.facebook.com/";
		String expectedURL=driver.getCurrentUrl();
		
		System.out.println("Expected home page title : "+expectedURL);
		
		Assert.assertEquals(actualURL, expectedURL);

}
}