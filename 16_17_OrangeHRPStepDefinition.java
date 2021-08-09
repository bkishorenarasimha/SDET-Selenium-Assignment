package test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.qa.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class OrangeHRPStepDefinition {
	OrangeHrpPages OrangeHRP;
	WebDriver Driver;
	
	@Given("^When I am in OrangeHRP Application$")
	public void when_I_am_in_OrangeHRP_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\sdet\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		Driver 	= new ChromeDriver(co);
		Driver.get("https://opensource-demo.orangehrmlive.com/");
		OrangeHRP = new OrangeHrpPages(Driver);
	}

	@Then("^Login to Application$")
	public void login_to_Application() {
	System.out.println(Driver.getTitle());
	OrangeHRP.settextforUserName("Admin");
	OrangeHRP.setTextforPassword("admin123");
	OrangeHRP.setStaySignedInClick();
	}

	@When("^Dashboard page is available$")
	public void dashboard_page_is_available()  {
	   OrangeHRP.getDashBoardisplayed();
	   System.out.println(Driver.getCurrentUrl());
	}

	@When("^click on Admin menu$")
	public void click_on_Admin_menu()  {
		OrangeHRP.settoAdminMenu();
	}

	@Given("^I am logged into Orange Application$")
	public void i_am_logged_into_Orange_Application()  {
		System.out.println(Driver.getTitle());
	}

	@When("^I click on Admin Link$")
	public void i_click_on_Admin_Link() {
		OrangeHRP.settoAdminMenu();
	}

	@Then("^Click on Job$")
	public void click_on_Job()  {
		OrangeHRP.settoJobMenu();
	}

	@Then("^validate text – Job Title$")
	public void validate_text_Job_Title()  {
		
		OrangeHRP.settoJobTitle();
		OrangeHRP.getJobTitle();
		
		
	@Then("^Close the browser$")
	public void close_the_browser() {
	Driver.close();
	Driver.quit();
	}
}