package com.capstonesteps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.CapstonePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CapstoneStepDefinition {

	private WebDriver driver;
	private CapstonePage capstonePage;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Given("I go to home page")
	public void i_go_to_home_page() {
		driver.get("http://webdriveruniversity.com/index.html");
		capstonePage = new CapstonePage(driver);
	}

	@When("click on iFrame link")
	public void click_on_i_frame_link() throws InterruptedException {
		capstonePage.clickiFrame();
		Thread.sleep(5000);	
	}

	@And("Shift control to newly opened tab")
	public void shift_control_to_newly_opened_tab() {
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Old Window: "+mainWindowHandle);
		Set<String> windowhandles = driver.getWindowHandles();
		
		
		for (String windowhandle: windowhandles) {
			if(!mainWindowHandle.equals(windowhandle)) {
			driver.switchTo().window(windowhandle);
			System.out.println("New Window: "+windowhandle);
		}
		}

	}

	@Then("verify the no of images")
	public void verify_the_no_of_images() {
		capstonePage.switchToFrame();
		capstonePage.compareImages();

	}

}
