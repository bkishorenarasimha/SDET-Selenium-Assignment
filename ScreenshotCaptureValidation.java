package test3;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotCaptureValidation {

	public static Properties prop; 
	public static FileInputStream fileLoc;
	WebDriver driver;
	@BeforeTest()
	public void BrowserOpen() throws InterruptedException {
		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"\\ExecutionProperties\\Config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("Url"));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		String  Username = prop.getProperty("username");
		String  Password = prop.getProperty("passwd");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}
	@Test(priority=2,dependsOnMethods= {"Login"})
	public void Search() throws InterruptedException
	{
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Linda Anderson");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void Screenshot() throws Exception
	{
		takeSnapShot(driver,"C:\\Users\\bhemisettik\\Desktop\\SDET\\Selenium Assignments\\Search.png");
	}

	@AfterTest
	public void logout()
	{
		driver.quit();
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	File DestFile=new File(fileWithPath);

	FileUtils.copyFile(SrcFile, DestFile);
	}
}