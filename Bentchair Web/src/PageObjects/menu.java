package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class menu{

		private static WebElement element = null;

		public static WebElement bent_studio(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FUNKY WINE HOLDERS'])[1]/following::a[1]"));

		return element;

}
}