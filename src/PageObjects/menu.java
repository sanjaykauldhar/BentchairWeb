package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class menu{

		private static WebElement element = null;

		public static WebElement company(WebDriver driver){

		//element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FUNKY WINE HOLDERS'])[1]/following::a[1]"));
		element = driver.findElement(By.xpath("//li[@class='menu-item menu-blog'][4]/a"));
		return element;

}
		public static WebElement bent_studio(WebDriver driver){

			element = driver.findElement(By.xpath("//li[@class='menu-item menu-blog'][4]/ul[@class='sub-menu']/li[5]/a"));
			return element;

	}
		
}