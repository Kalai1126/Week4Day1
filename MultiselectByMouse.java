package week4.Day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiselectByMouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		Actions mouseSelect = new Actions(driver);
		WebElement option1 = driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[6]/select[1]//option[3]");
		WebElement option2 = driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[6]/select[1]//option[5]");

		mouseSelect.click(option1).keyDown(Keys.CONTROL).click(option2).perform();
		if(option1.isSelected())System.out.println("Appium is selected successfully");
		if(option2.isSelected())System.out.println("Loadrunner is selected successfully");

	}

}
