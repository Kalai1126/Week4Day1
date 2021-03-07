package week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealMousehover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.manage().window().maximize();
		
		WebElement deal1 = driver.findElementByXPath("//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]");
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(deal1).perform();
		WebElement deal2 = driver.findElementByXPath("//span[text()='Loafers']");
		mousehover.click(deal2).perform();
		Thread.sleep(3000);
		mousehover.moveToElement(driver.findElementByXPath("(//p[@class='product-title '])[1]")).perform();
		mousehover.click(driver.findElementByXPath("//div[text()[normalize-space()='Quick View']]")).perform();
		String Product = driver.findElementByXPath("(//p[@class='product-title '])[1]").getText();
		System.out.println("The Quick view of the product: "+Product+" is viewed successfully.");
		driver.close();
	}

}
