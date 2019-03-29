package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class POR_Form{

		private static WebElement element = null;

		public static WebElement form_name(WebDriver driver){

		element = driver.findElement(By.id("form_name"));

		return element;

}
		public static WebElement form_email(WebDriver driver){

			element = driver.findElement(By.id("form_email"));

			return element;

	}
		public static WebElement form_contact(WebDriver driver){

			element = driver.findElement(By.id("form_contact"));

			return element;

	}
		public static WebElement form_city(WebDriver driver){

			element = driver.findElement(By.xpath("//input[@id='form_city ']"));

			return element;

	}
		public static WebElement form_message(WebDriver driver){

			element = driver.findElement(By.id("form_message"));

			return element;

	}
		public static WebElement req_agree(WebDriver driver){

			element = driver.findElement(By.xpath("//*[@id=\"req_agree\"]"));

			return element;

	}
		public static WebElement SUBMIT(WebDriver driver){

			element = driver.findElement(By.xpath("//*[@id=\"bentchair-form\"]/div[5]/div/button"));

			return element;

	}

}