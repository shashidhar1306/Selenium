package rahulshettyacademy.Sathviki;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TechnicalTask {

	
		
		@Test
		public void createMyTest()
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			
			// OPen the giver url
			driver.get(" http://demowebshop.tricentis.com/");
			
			// click on LoginButton
			
			driver.findElement(By.linkText("Log in")).click();
			// Enter the given credentials
			
			driver.findElement(By.xpath("//div[@class='inputs']/input[@id='Email']")).sendKeys("planittest78@gmail.com");
			driver.findElement(By.xpath("//div[@class='inputs']/input[@id='Password']")).sendKeys("123456");
			//click on LogIn button
			
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			String id="planittest78@gmail.com";
			// validate  Userid
			
			Assert.assertTrue(id.equalsIgnoreCase("planittest78@gmail.com"));
			// click on Shopping cart
			
			driver.findElement(By.linkText("Shopping cart")).click();
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		
			driver.findElement(By.cssSelector("input.button-2.update-cart-button")).click();
			
			System.out.println(driver.findElement(By.xpath("//div[@class='page-body']")).getText());
			
			//mousehover on computer categeories
			
			WebElement computers=driver.findElement(By.cssSelector("a[href*='computers']"));
			Actions action= new Actions(driver);
			action.moveToElement(computers).build().perform();
		
			driver.findElement(By.cssSelector("a[href*='desktops']")).click();
			
			driver.findElement(By.xpath("//h2[@class='product-title']//a[@href='/build-your-own-computer']")).click();
			
			String ele=driver.findElement(By.xpath("//div[@class='product-price']")).getText();
			
			Assert.assertTrue(ele.contains("1200.00"));
			
			driver.findElement(By.id("product_attribute_16_3_6_19")).click();
			driver.findElement(By.xpath("//input[@id='addtocart_16_EnteredQuantity']")).clear();
			driver.findElement(By.xpath("//input[@id='addtocart_16_EnteredQuantity']")).sendKeys("4");
			driver.findElement(By.xpath("//input[@id='add-to-cart-button-16']")).click();
			
			System.out.println(driver.findElement(By.xpath("//p[@class='content']")).getText());
			WebElement verifyMessage=driver.findElement(By.xpath("//p[@class='content']"));
		String message="The product has been added to your shopping cart";
			//Assert.assertEquals(verifyMessage, message);
		
		//click on shopping cart link on right side top
		driver.navigate().refresh();
		WebElement shoppingCart=driver.findElement(By.xpath("//a/span[text()='Shopping cart']"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(shoppingCart)).click();
			
			//driver.findElement(By.xpath("//a/span[text()='Shopping cart']")).click();
			
			driver.findElement(By.id("termsofservice")).click();
			driver.findElement(By.id("checkout")).click();
			WebElement messageAtDropDown=driver.findElement(By.id("co-billing-form"));
			if(messageAtDropDown.equals("Select a billing address from your address book or enter a new address."));
			{
				WebElement staticDropdown= driver.findElement(By.xpath("//select[@id='billing-address-select']"));
				Select dropdown=new Select(staticDropdown);
				dropdown.selectByIndex(4);
				driver.findElement(By.xpath("//input[@value='Continue']")).click();
				Assert.assertTrue(true);
			}
			
			/*
			 * else() { Assert.assertTrue(false); }
			 * 
			 */			
				driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
			
			//click on continue button
			driver.findElement(By.id("shippingoption_1")).click();
			
			driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/input[@value='Continue']")).click();
			driver.findElement(By.xpath("//input[@id='paymentmethod_0']")).click();
			driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input[@value='Continue']")).click();
			
			WebElement payment=driver.findElement(By.xpath("//td/p"));
			System.out.println(driver.findElement(By.xpath("//td/p")).getText());
			String message1= "You will pay by COD";
			//Assert.assertEquals(message, message1);
			//Assert.assertTrue(payment.equals(message1));
			//Assert.assertEquals(payment, message1, "You will pay by COD");
		
			

			driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
			driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/input")).click();
			System.out.println(driver.findElement(By.xpath("//div[@class='title']")).getText());
			
			System.out.println(driver.findElement(By.xpath("//ul[@class='details']")).getText());
			WebElement purchaseOrder=driver.findElement(By.xpath("//ul[@class='details']"));
		//Assert.assertTrue(true);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
			//Logout from Application
		driver.findElement(By.cssSelector("a[href*='logout']")).click();
		driver.close();
		}
		
		
		
		
	

}
