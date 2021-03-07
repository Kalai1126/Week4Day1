package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();        
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		Actions mousemove = new Actions(driver);
		WebElement item1 = driver.findElementByXPath("//ul[@id='sortable']//li[1]");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", item1);
		WebElement item4 = driver.findElementByXPath("//ul[@id='sortable']//li[4]");

		int x = item4.getLocation().getX();
		int y = item4.getLocation().getY();

		mousemove.clickAndHold(item1).dragAndDropBy(item1, x, y).release().perform();

		int a = item1.getLocation().getX();
		int b= item1.getLocation().getY();
		if(a==x && b==y)System.out.println("The Item 1 is switched successfully to item 4");
		
	}

}
