package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSliders {
		
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void main(String[] args) {
		
		org.apache.log4j.PropertyConfigurator.configure("C:\\Users\\ujwalrajshekar\\eclipse-workspace\\logger\\src\\test\\resources\\log4j.properties");

		WebDriver driver = new ChromeDriver();
		log.debug("Driver launched :"+driver);
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		log.debug("Navigated to the site :"+driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		
		int width = driver.findElement(By.xpath("//*[@id='slider']")).getSize().width/2;
		
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
		
		driver.quit();

	}

}
