package test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 public class AdminLinkValidation {

    public static void main(String[] args) {
 
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");	
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
       
	    driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));

             username.sendKeys("Admin");
             password.sendKeys("admin123");
             login.click();
 
       String actualUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	   
       String expectedUrl = driver.getCurrentUrl();
	   
       Assert.assertEquals(expectedUrl,actualUrl);
	   
	   System.out.println("Login is Successful");
	   
	   driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
	   Webelement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
	   Admin.click();
	   
	    if(driver.findElement(By.cssSelector("#menu_admin_UserManagement")!= null))
          {
            System.out.println("User Management is Present");
          }
          else
          {
            System.out.println("User Management is not Present");
          }
         
          if(driver.findElement(By.cssSelector("#menu_admin_Job")!= null))
          {
            System.out.println("Job is Present");
          }
          else
          {
            System.out.println("User Management is not Present");
          }
         
          if(driver.findElement(By.cssSelector("#menu_admin_Organization")!= null))
          {
            System.out.println("Organization is Present");
          }
          else
          {
            System.out.println("Organization is not Present");
          }
         
          if(driver.findElement(By.cssSelector("#menu_admin_Qualifications")!= null))
          {
            System.out.println("Qualifications is Present");
          }
          else
          {
            System.out.println("Qualifications is not Present");
          }
	   driver.close();
    }
 }