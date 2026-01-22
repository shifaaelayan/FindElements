package findelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestCases {

	WebDriver driver = new EdgeDriver();
	String WebsiteUrl = "https://www.saucedemo.com/";
	
	String username = "standard_user";
	String password = "secret_sauce";
	
	
	@BeforeTest
	public void setup()
	{
		driver.get(WebsiteUrl);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
	}
	
	@Test(priority = 1)
	public void login()
	{
		WebElement usernameF = driver.findElement(By.id("user-name"));
		usernameF.sendKeys(username);
		
		WebElement passwordF = driver.findElement(By.id("password"));
		passwordF.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		loginBtn.click();
		
	}
	
	@Test(priority = 2)
	public void addElements() // Buttons are all have the same classes (all Buttons have the same behavior)
	{
		//driver.findElements(By.className("btn btn_primary btn_small btn_inventory")); --> more than one class 
		
		// use all classes. to use it, you must use a cssSelector locator and remove space between classes and put . instead
		List <WebElement> addToCart = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")); // 4 classes
		//findElements return List of WebElement
		// using click() is for each WebElement (get the element one by one)
		
//		addToCart.get(0).click();
//		addToCart.get(1).click();
//		addToCart.get(2).click();  
//		addToCart.get(3).click();
//		addToCart.get(4).click();
//		addToCart.get(5).click();
		
		// using for loop:
		for(int i=0; i<addToCart.size(); i++) // addToCart.size() --> the size of list
		{
			addToCart.get(i).click();
		} // and all items will add.
	}
		
		@Test(priority = 3)
		public void removeElements() // one class changed after the add (btn_primary to btn_secondary)
		{
			List <WebElement> removeFromCart = driver.findElements(By.className("btn_secondary")); 
			for(int i=0; i<removeFromCart.size(); i++) 
			{
				removeFromCart.get(i).click();
			} 
			
		}
		
	
	
	@AfterTest
	public void cleanup()
	{
		
	}
}
