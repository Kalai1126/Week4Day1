package week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElementById("iframeResult"));
		driver.findElementByXPath("//button[text()='Try it']").click();
		
				
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text = driver.findElementByXPath("//p[text()='You pressed OK!']").getText();
		System.out.println(text);
			
		File source = driver.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String strDate = date.toString();
		System.out.println("");
		String newStr = strDate.replaceAll(":", "");
		File target = new File("./snaps/TryItFrame_"+newStr+".png");
		FileUtils.copyFile(source, target);

		
		

		
	}

}
