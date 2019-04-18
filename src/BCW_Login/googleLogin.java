package BCW_Login;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.google.common.io.Files;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleLogin {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGoogleLogin() throws Exception {
	try {
    driver.get("https://www.bentchair.com/");
    driver.manage().window().maximize();
    WebElement clickLogin = driver.findElement(By.className("quick-login"));
    clickLogin.click();
    
    //Store the current window handle
    String winHandleBefore = driver.getWindowHandle();

    // Perform the click operation that opens new window
    WebElement googleLogin = driver.findElement(By.id("googlelogin"));
    googleLogin.click();
    
    // Switch to new window opened
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }

    // Perform the actions on new window
    WebElement enterEmail = driver.findElement(By.id("identifierId"));
    enterEmail.sendKeys("sanjaykauldhar123@gmail.com");
    WebElement userNext = driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])"));
    userNext.click();
    
    WebElement enterPass = driver.findElement(By.xpath("//input[@name='password']"));
    enterPass.sendKeys("Sanj@2904");
    //WebElement passNext = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
    //passNext.click();
    WebElement passNext= driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));

    JavascriptExecutor executor4 = (JavascriptExecutor) driver;
    executor4.executeScript("arguments[0].click();", passNext);
    
    driver.switchTo().window(winHandleBefore);
    
    Thread.sleep(5000);
	
    Actions action = new Actions(driver);
    WebElement we = driver.findElement(By.xpath("//li[@class='menu-item menu-blog-top'][2]/a"));
    action.moveToElement(we).build().perform();
    
    WebElement LOGOUT =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sub-menu sub-menutop']/li[5]/a")));
    LOGOUT.click();
  }
	catch(Exception e)
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     Files.copy(screenshotFile, new File("E:\\google_login.jpg"));
	}
     
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
