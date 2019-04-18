package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class BYA_Form{

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
		public static WebElement form_company(WebDriver driver){

			element = driver.findElement(By.id("form_company "));

			return element;

	}
		public static WebElement form_date(WebDriver driver){

			element = driver.findElement(By.id("form_date"));

			return element;

	}
		public static WebElement form_time(WebDriver driver){

			element = driver.findElement(By.id("form_time"));

			return element;

	}
		public static WebElement form_message(WebDriver driver){

			element = driver.findElement(By.id("form_message"));

			return element;

	}
		public static WebElement req_agree(WebDriver driver){

			element = driver.findElement(By.id("req_agree"));

			return element;

	}
		public static WebElement SUBMIT1(WebDriver driver){

			element = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));

			return element;

	}
		public static WebElement SUBMIT2(WebDriver driver){

			element = driver.findElement(By.xpath("//*[@id=\"mob-bg\"]"));

			return element;

	}
		public static WebElement captcha(WebDriver driver){

			element = driver.findElement(By.id("input-captcha"));

			return element;

	}
		public static WebElement error(WebDriver driver){

			element = driver.findElement(By.id("error"));

			return element;

	}
		public static WebElement appointment(WebDriver driver){

			element = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg westend-btn']"));

			return element;

	}
		public static WebElement submit(WebDriver driver){

			element = driver.findElement(By.id("form_sub_btn"));

			return element;

	}
		
		
}
