package Sellogin.SelLogin;



	import static org.junit.Assert.*;
	import java.util.concurrent.TimeUnit;
	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import junit.framework.Assert;
	
	public class ÖnskelisaTc {
		  private static WebDriver driver;
		  public static WebDriverWait wait;
		  public static String baseUrl="https://www.br.se/";
		  
		  //Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database.
		  @BeforeClass
		  public static void setupClassOnce()  {
			// Create a new instance of the Firefox driver
		    driver = new FirefoxDriver();
		//  Wait For Page To Load
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  }
	
	
	
	        @Test
	  	    public void testcaseLogin()  {
		    driver.get(baseUrl + "/");
		    //Click on login button
		    driver.findElement(By.cssSelector("div.clubbr__icon")).click();
		   // Write username
		    driver.findElement(By.id("j_username")).sendKeys("mndana.rose@gmail.com");
		    // Write password
		    driver.findElement(By.id("j_password")).sendKeys("koftkoft");
		  	       		    
		 //Click on Submitt knappen
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
	     // Wait For Page To Load
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     //Search for product in search engine   
	    driver.findElement(By.id("js-site-search-input")).clear();
	    //Write a products name
	    driver.findElement(By.id("js-site-search-input")).sendKeys("LARSEN pussel - världskarta");
	    driver.findElement(By.id("btnSearch")).click();
	    //Choose product
	    driver.findElement(By.cssSelector("img[alt=\"LARSEN pussel -  världskarta\"]")).click();
	    //Add to wish list
	   
	    driver.findElement(By.linkText("Lägg till på önskelistan")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id='iconbar']/div[2]/div")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   
	    
	  }
	        //Executed after each test. It is used to cleanup the test environment 
			  @After
			  public void aftertest()
			  {
			  System.out.println("test is over");
			  }
			  
	         //Executed once, after all tests have been finished. It is used to perform clean-up activities. for example, to disconnect from a database
	         @AfterClass
	         public static void closeBrowser(){
		     //Close the browser.
		     driver.close();
		     try{
			 Thread.sleep(5000);
		     }catch(InterruptedException e){
			 System.out.println(e.getStackTrace());
		     }
		     driver.quit();
	         }
	                        


}
