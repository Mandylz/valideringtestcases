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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class loginTest {

		  private static WebDriver driver;
		  public static WebDriverWait wait;
		  public static String baseUrl="https://www.br.se/";
		  
		  //Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database.
		  @BeforeClass
		  public static void setupClassOnce()  {
			// Create a new instance of the Firefox driver
		    driver = new FirefoxDriver();
		    
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  public class Tutorials {
			  
			    public void waitForLoad(WebDriver driver) {
			        ExpectedCondition<Boolean> pageLoadCondition = new
			                ExpectedCondition<Boolean>() {
			                    public Boolean apply(WebDriver driver) {
			                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			                    }
			                };
			        WebDriverWait wait = new WebDriverWait(driver, 30);
			        wait.until(pageLoadCondition);
			    }
			}
			
		  @Test
		  public void testcaseLogin()  {
		    driver.get(baseUrl + "/");
		    //Click on login button
		    driver.findElement(By.cssSelector("div.clubbr__icon")).click();
		 // Write username
		    try
	        {
		    driver.findElement(By.id("j_username")).sendKeys("mndana.rose@gmail.com");
		    System.out.println("---------Email exists --------------\n-----------------------");
	     // Write password
		    driver.findElement(By.id("j_password")).sendKeys("koftkoft");
		    System.out.println("---------pass exists --------------\n-----------------------");
	        		    
		     //Click on "Logga in" button
		    driver.findElement(By.xpath("//*[@id='loginForm']/div[3]/button")).click();
		   
	        }
		    catch(Throwable e)
	         {
		    System.out.println("---------kontot hittates inte ----------\n------------------");
	         }
	     // Wait For Page To Load
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        
	        
	       driver.getCurrentUrl();
	       System.out.println("CURRENT URL:" + driver.getCurrentUrl());
	        System.out.println("title:"+driver.getTitle());
	       
	        
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


