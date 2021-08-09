package test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeSuiteAnnotation 
{@Test
    public void beforeSuiteTesting()
	{
		System.out.println("Before Suite Execution");
	}
	@BeforeSuite
		public void before_suite() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		driver.close();
	}

}