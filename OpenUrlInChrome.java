package test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrlInChrome {

    public static void main(String[] args) {
    
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
        driver.close();
    }
}