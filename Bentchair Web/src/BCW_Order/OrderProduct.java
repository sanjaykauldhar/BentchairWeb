package BCW_Order;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProduct {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testOrderProduct() throws Exception {
	  driver.get("https://www.bentchair.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='د.إ UAE'])[1]/following::a[1]")).click();
	    driver.findElement(By.id("input-email")).click();
	    driver.findElement(By.id("input-email")).clear();
	    driver.findElement(By.id("input-email")).sendKeys("sanjay.kauldhar@bentchair.com");
	    driver.findElement(By.id("input-password")).clear();
	    driver.findElement(By.id("input-password")).sendKeys("sanjay");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Recover Password'])[1]/preceding::input[1]")).click();
	    driver.findElement(By.id("filter_names")).click();
	    driver.findElement(By.id("filter_names")).clear();
	    driver.findElement(By.id("filter_names")).sendKeys("test");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[2]/following::img[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FILTERS'])[1]/following::img[1]")).click();
	    
	    //New Tab Start
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    //driver.close();
	    //driver.switchTo().window(tabs2.get(0));
	    //New Tab End
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
	    WebElement ADD_TO_CART = driver.findElement(By.id("Dbutton-cart"));
	    ADD_TO_CART.click();
	       
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View Cart'])[1]/i[1]")).click();
	    
	    WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", checkout);
	    
	    WebElement checkoutContinue = driver.findElement(By.xpath("//button[@id='button-shipping-address']"));
	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	    executor1.executeScript("arguments[0].click();", checkoutContinue);
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('You', \"'\", 've Done It! You Saved Some Money!')])[1]/following::input[3]")).click();
	    
	    /*WebElement TERM = driver.findElement(By.name("agree"));
	    JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	    executor3.executeScript("arguments[0].click();", TERM);*/
	    
	    driver.findElement(By.id("button-payment-method")).click();
	  
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.titleContains("Success"));
	    
	    Actions action = new Actions(driver);
	    WebElement we = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='د.إ UAE'])[1]/following::a[1]"));
	    action.moveToElement(we).build().perform();
	    
	    WebElement LOGOUT = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Become a Seller'])[1]/following::a[1]"));
	    LOGOUT.click();
  }
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
