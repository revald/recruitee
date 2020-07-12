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
import java.util.List;

public class TwoRecruitee {
	
	WebDriver driver = new FirefoxDriver();
	

	  
	public TwoRecruitee() {
		// TODO Auto-generated constructor stub
	}


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
	public void testNegativeOne() {  

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[9]/button"));
		submitBtn.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		List<WebElement> dynamicElement = driver.findElements(By.className("auth-form__title"));
		if(dynamicElement.size() != 0){
		 //If list size is non-zero, element is present
		 System.out.println("Element present");
		 Assert.fail("We should not get to this page");
		} 
		else{
		 //Else if size is 0, then element is not present
		 System.out.println("Element not present");
		}
		
		WebElement companyNameLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[3]/div/div/div[2]/div"));
		companyNameLabel.isDisplayed();
		Assert.assertEquals("Пожалуйста, укажите название компании",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[3]/div/div/div[2]/div")).getText());

		WebElement firstNameLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[4]/div/div/div[2]/div"));
		firstNameLabel.isDisplayed();
		Assert.assertEquals("Пожалуйста, укажите имя",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[4]/div/div/div[2]/div")).getText());

		WebElement lastNameLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[5]/div/div/div[2]/div"));
		lastNameLabel.isDisplayed();
		Assert.assertEquals("Пожалуйста, укажите фамилию",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[5]/div/div/div[2]/div")).getText());

		WebElement emailLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[6]/div/div/div[2]/div"));
		emailLabel.isDisplayed();
		Assert.assertEquals("Обязательное поле",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[6]/div/div/div[2]/div")).getText());

		WebElement passwordLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[7]/div/div[1]/div[2]"));
		passwordLabel.isDisplayed();
		Assert.assertEquals("Введите пароль",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[7]/div/div[1]/div[2]")).getText());
		 
		WebElement firstPassField = driver.findElement(By.name("first_password"));
		firstPassField.sendKeys("123abc");		
		WebElement secondPassField = driver.findElement(By.name("second_password"));
		secondPassField.sendKeys("123abc"); 
		submitBtn.click();
		
		Assert.assertEquals("Пароль слишком короткий. Он должен содержать от восьми до тридцати двух символов",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[7]/div/div[1]/div[2]")).getText());
		
		firstPassField = driver.findElement(By.name("first_password")); 
		firstPassField.sendKeys("123abc123");		
		secondPassField = driver.findElement(By.name("second_password"));
		secondPassField.sendKeys("123abc1234");
		submitBtn.click();
		
		Assert.assertEquals("Пароли не совпадают, попробуйте указать их снова",driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/form/div[7]/div/div[1]/div[2]")).getText());
		
  } 

 
	@AfterTest
	public void closeUp() {
		
		//closing the browser
		driver.close();
	  
	} 

}
