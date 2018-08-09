package testcases;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSliders3 {
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	String url ="https://jqueryui.com/resources/demos/slider/default.html";
	String browser = "chrome";
	String remoteUrl = "http://localhost:4444/wd/hub";
	
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
		public WebDriver getDriver() {
		return driver.get();
	}
		
		public void initialSetup() throws IOException {
			org.apache.log4j.PropertyConfigurator.configure("C:\\Users\\ujwalrajshekar\\eclipse-workspace\\logger\\src\\test\\resources\\log4j.properties");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName(browser);
			desiredCapabilities.setJavascriptEnabled(true);
			desiredCapabilities.setPlatform(Platform.ANY);
			driver.set(new RemoteWebDriver(new URL(remoteUrl), desiredCapabilities));
			getDriver().get(url);
			getDriver().manage().window().maximize();
		}
		
		
	@Test
	public void testLogs() throws IOException {
		initialSetup();

		//WebDriver driver = new ChromeDriver();
		log.debug("Driver launched :"+driver);
		//driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		log.debug("Navigated to the site :"+getDriver().getCurrentUrl());
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		WebElement slider = getDriver().findElement(By.xpath("//*[@id='slider']/span"));
		
		
		int width = getDriver().findElement(By.xpath("//*[@id='slider1']")).getSize().width/2;
		
		new Actions(getDriver()).dragAndDropBy(slider, width, 0).perform();
		
		getDriver().quit();

	}
	
	@Test
	public void testLogs2() throws IOException {
		initialSetup();

		//WebDriver driver = new ChromeDriver();
		log.debug("Driver launched :"+driver);
		//driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		log.debug("Navigated to the site :"+getDriver().getCurrentUrl());
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		WebElement slider = getDriver().findElement(By.xpath("//*[@id='slider']/span"));
		
		
		int width = getDriver().findElement(By.xpath("//*[@id='slider']")).getSize().width/2;
		
		new Actions(getDriver()).dragAndDropBy(slider, width, 0).perform();
		
		getDriver().quit();

	}

}
