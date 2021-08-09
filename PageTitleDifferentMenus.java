package test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.pages.*;

public class PageTitleDifferentMenus {
	
    static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		try {
			String Username = "Admin";
			String Password = "admin123";
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Username);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
			driver.findElement(By.id("btnLogin")).click();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		@SuppressWarnings("unused")
		OrangeHrpPages orgpg = new OrangeHrpPages(driver);
		driver.findElement(By.linkText("Admin"));
		Thread.sleep(1000);
		String main = Admintab();
		System.out.println(main);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(1000);
		String PIMpage = PIMtab();
		System.out.println(PIMpage);
		driver.findElement(By.id("menu_dashboard_index")).click();
		Thread.sleep(1000);
		String Dashboardpage = LeaveDashBoardtab();
		System.out.println(Dashboardpage);
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		Thread.sleep(1000);
		String Directorypage = Directorytab();
		System.out.println(Directorypage);
		driver.findElement(By.id("menu_maintenance_purgeEmployee")).click();
		Thread.sleep(1000);
		String Maintainencepage = Maintanencetab();
		System.out.println(Maintainencepage);
}
	public static String Admintab() {
		String ReqText = driver.findElement(By.id("menu_admin_UserManagement")).getText();
		return ReqText;
	}

	public static String PIMtab() {
		String ReqText = driver.findElement(By.id("menu_pim_viewEmployeeList")).getText();
		return ReqText;
	}

	public static String LeaveDashBoardtab() {
		String ReqText = driver.findElement(By.id("menu_dashboard_index")).getText();
		return ReqText;
	}

	public static String Directorytab() {
		String ReqText = driver.findElement(By.id("menu_directory_viewDirectory")).getText();
		return ReqText;
	}

	public static String Maintanencetab() {
		String ReqText = driver.findElement(By.id("menu_maintenance_purgeEmployee")).getText();
		return ReqText;
	}
}
