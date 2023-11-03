package com.capstonesteps;

import java.util.Set;

import com.pages.CapstonePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CapstoneStepDefinition extends BaseClass{


	private CapstonePage capstonePage;
	@Before
	public void SetupMethod() {
		Setup();
	}

	@After
	public void tearDownMethod() {
		tearDown();
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
		Set<String> windowhandles = driver.getWindowHandles();
		
		
		for (String windowhandle: windowhandles) {
			if(!mainWindowHandle.equals(windowhandle)) {
			driver.switchTo().window(windowhandle);
		}
		}

	}

	@Then("verify the no of images")
	public void verify_the_no_of_images() {
		capstonePage.switchToFrame();
		capstonePage.compareImages();

	}

}
