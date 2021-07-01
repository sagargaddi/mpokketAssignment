
package com.selenium.test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Amazon {
	
	public static WebDriver driver= new ChromeDriver(); 
	
	public static void main(String args[]) throws Exception {
	
		
			launchBrowser();
			amazon_ProductSearch();
			foundProduct();
			addProductCart();
			increase_Cartcount_VerifyPrice();
			remove_ProductCart();
			closeBrowser();
	}
	
	
		public static void launchBrowser()
		
		{		
			
			// System Property for Chrome Driver   
	       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\mpokketassignment\\utilities\\chromedriver.exe");  
			
			 // Instantiate a ChromeDriver class.     
	        //WebDriver driver= new ChromeDriver();  
	          
	           // Launch Website  
	        driver.navigate().to("https://www.amazon.in/");  
	          
	         //Maximize the browser  
	          driver.manage().window().maximize();  

			
		}
		

		public static void closeBrowser()
		{
			thread.sleep(5);
			driver.quit();
		}
	

	public static void amazon_ProductSearch() throws InterruptedException {
		
		driver.findElement(By.id("twotabsearchtextbox")).click();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung");
		
		driver.findElement(By.id("'nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
	}
	
	public static void foundProduct()
	
	{
		String productName = "Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB Storage";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    List<WebElement> products = driver.findElements(By.id("//div[@id='search']/div/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span"));
	    for (WebElement product : products)
	    {
	        if (product.getText().trim().equals(productName)) {
	            System.out.print(productName);
	    }

	    else {
	    	System.out.print("No Product foud");
	    }
	   } 
	    
	}

	
	public static void addProductCart() throws InterruptedException {
		
		driver.findElement(By.name("Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB Storage")).click();
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Assert.assertEquals("Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB Storage", driver.getPageSource());
		
		Thread.sleep(2000);
	}
	
	public static void increase_Cartcount_VerifyPrice() throws InterruptedException {
		
		String element1 = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")).getText();
		//Prints the value of one device
		System.out.print(element1);
		
		WebElement dropdown_Qty = driver.findElement(By.cssSelector("span.a-dropdown-label"));
		dropdown_Qty.click();
		Select select1 = new Select(dropdown_Qty);
		select1.selectByVisibleText("6");
		Thread.sleep(5000);
		
		String element2 = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")).getText();
		
		//prints the value of 6 devices added.
		//However in the amazon website some sellers are allowed to sell 1 device per person
		System.out.println(element2);
		
		if (element1!=element2)
		{
			System.out.print("Price has changed");
			System.out.print(element2);
		}
		else {
			System.out.print(element1);
		}
		
		Thread.sleep(3000);
	}
	
	
	
	
		public static void remove_ProductCart() throws InterruptedException {
			
			WebElement dropdown_Qty = driver.findElement(By.cssSelector("span.a-dropdown-label"));
			dropdown_Qty.click();
			Select select1 = new Select(dropdown_Qty);
			select1.selectByVisibleText("6");
			
			Thread.sleep(5000);
			
			String element2 = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")).getText();
			
			//prints the value of 6 devices added.
			//However in the amazon website some sellers are allowed to sell 1 device per person
			
			System.out.println("driver.findElement(By.cssSelector(\"span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold\"))");
			
			//selecting this will delete the added product in the cart
			driver.findElement(By.cssSelector("submit.delete.C980aafa6-98d1-4a35-9389-49d214005dda")).click();
			
			
			
			
		}
		
	}

