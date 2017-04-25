package Sellogin.SelLogin;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HittaButikTc {
	private static WebDriver driver;
    public static WebDriverWait wait;
    private StringBuffer verificationErrors = new StringBuffer();
    public static String baseUrl="https://www.br.se/";

@Test
public void testHitta() throws Exception {
  driver.get(baseUrl + "/");
  driver.findElement(By.cssSelector("#find-store-link-id > span.text")).click();
  driver.findElement(By.id("address-search")).clear();
  driver.findElement(By.id("address-search")).sendKeys("stockholm");
  driver.findElement(By.id("address-search")).clear();
  driver.findElement(By.id("address-search")).sendKeys("16960");
  
}

@After
public void tearDown() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}

private boolean isElementPresent(By by) {
  try {
    driver.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}
}

