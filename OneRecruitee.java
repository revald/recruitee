package recruitee;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OneRecruitee { 
	
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() { 
				 
		//wait 10 seconds	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		//open browser with given URL
		driver.get("https://app.recruitee.ru/sign-up/company");
	}
		
	// positive test
	@Test
	public void testPositiveOne() {
	  
		WebElement companyNameField = driver.findElement(By.name("company_name"));
		companyNameField.sendKeys("Big Company Name");
		
		WebElement firstNameField = driver.findElement(By.name("first_name"));
		firstNameField.sendKeys("Ivan");		
		
		WebElement lastNameField = driver.findElement(By.name("last_name"));
		lastNameField.sendKeys("Ivanov");
		 
		
		WebElement emailField = driver.findElement(By.name("email_form"));
		emailField.sendKeys("ivan@big.com");
		
		WebElement firstPassField = driver.findElement(By.name("first_password"));
		firstPassField.sendKeys("123abc123");		
		WebElement secondPassField = driver.findElement(By.name("second_password"));
		secondPassField.sendKeys("123abc123");
		
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[9]/button"));
		submitBtn.click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Assert.assertEquals("Ваш аккаунт успешно создан",driver.findElement(By.className("auth-form__title")).getText());
		
	  
  }
	
   
	@AfterTest
	public void closeUp() {
		
		//closing the browser
		driver.close();
	  
	}

}
