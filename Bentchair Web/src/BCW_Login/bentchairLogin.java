package BCW_Login;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class bentchairLogin {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBentchairLogin() throws Exception {
    driver.get("https://www.bentchair.com/");
    driver.manage().window().maximize();
    WebElement login = driver.findElement(By.className("quick-login"));
    login.click();
    WebElement enterEmail = driver.findElement(By.id("input-email"));
    enterEmail.sendKeys("sanjay.kauldhar@bentchair.com");
    WebElement enterPass = driver.findElement(By.id("input-password"));
    enterPass.sendKeys("sanjay");
    WebElement clickSubmit = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-lg btn-block']"));
    clickSubmit.submit();
    
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
