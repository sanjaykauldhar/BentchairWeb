package BCW_Login;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookLogin {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFacebookLogin() throws Exception {
    driver.get("https://www.bentchair.com/");
    driver.manage().window().maximize();
    WebElement clickLogin = driver.findElement(By.className("quick-login"));
    clickLogin.click();
    
    // Store the current window handle
    String winHandleBefore = driver.getWindowHandle();

    // Perform the click operation that opens new window
    WebElement clickfacebook = driver.findElement(By.xpath("//button[@class='register-facebook register-button']"));
    clickfacebook.click();
    
    // Switch to new window opened
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }

    // Perform the actions on new window
    WebElement enterEmail = driver.findElement(By.id("email"));
    enterEmail.sendKeys("sanjaykauldhar123@gmail.com");
    WebElement enterPass = driver.findElement(By.id("pass"));
    enterPass.sendKeys("Sanj@2904");
    WebElement clickSubmit = driver.findElement(By.id("loginbutton"));
    clickSubmit.click();
    //WebElement enterPass1 = driver.findElement(By.name("pass"));
    //enterPass1.sendKeys("Sanj@2904");
    //driver.findElement(By.id("u_0_0")).submit();
    
    // Switch back to original browser (first window)
    driver.switchTo().window(winHandleBefore);

    Thread.sleep(5000);
    // Continue with original browser (first window)
    //Logout
    Actions action = new Actions(driver);
    WebElement we = driver.findElement(By.xpath("//li[@class='menu-item menu-blog-top'][2]/a"));
    action.moveToElement(we).build().perform();
    
    WebElement LOGOUT =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sub-menu sub-menutop']/li[5]/a")));
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
