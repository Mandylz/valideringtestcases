package Sellogin.SelLogin;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

  public class sökfältetTc {
       private static WebDriver driver;
       public static WebDriverWait wait;
       public static String baseUrl="https://www.br.se/";
      

  @BeforeClass
  public static void setupClassOnce()  {
       driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }


  @Test
  public void testCasesökfältet()  {
       driver.get(baseUrl + "/");
       //Clean Searchbar
       driver.findElement(By.id("js-site-search-input")).clear();
       //Write product
       driver.findElement(By.id("js-site-search-input")).sendKeys("kort");
       //Click to Show result
       driver.findElement(By.id("btnSearch")).click();
       //Get "Sökresultat" 
       String Result= driver.findElement(By.xpath("//*[@id='content']/div[1]/header/h1")).getText();
       System.out.println("Result is:  "+ Result);
       //validate that "Sökresultat"is shown
       if (Result.contains("Sökresultat")){
    	   System.out.print("Yes--\n");
    	   }
       else{System.out.print("No--\n");
       }
       driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       
  }
  
  @After
  public void aftertest()
  {
  System.out.println("test is over");
  }


  @AfterClass
  public static void closeBrowser(){
  driver.close();
  try{
  Thread.sleep(3000);
  }catch(InterruptedException e){
  System.out.println(e.getStackTrace());
  }
  driver.quit();
  }
  
  }
 
