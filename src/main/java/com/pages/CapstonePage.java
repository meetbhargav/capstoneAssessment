package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CapstonePage {
	
	private WebDriver driver;
	private String image1 = "http://webdriveruniversity.com/img/amp.svg";
	private String image2 = "http://webdriveruniversity.com/img/boombox.svg";
	private String image3 = "http://webdriveruniversity.com/img/nintendo.svg";
	
	
	//Locators
	private By iFrameLinkLocator = By.id("iframe");
	private By iFrameLocator = By.id("frame");
	private By imagesLocator = By.xpath("//div[@class='carousel-inner']//img");
	
	
	//Constructor
	public CapstonePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods
	public void clickiFrame() {
		WebElement iFrameLink = driver.findElement(iFrameLinkLocator);
		iFrameLink.click();
	}

	public void switchToFrame() {
		WebElement iFrame = driver.findElement(iFrameLocator);
		driver.switchTo().frame(iFrame);
		System.out.println("Switched!");
	}
	
	public void compareImages() {
		List<WebElement> images = driver.findElements(imagesLocator);
		
		for(WebElement element:images) {
			String attributeValue = element.getAttribute("src");

			if(attributeValue.equals(image1)) {
				Assert.assertTrue(attributeValue.equals(image1), "Image One Found !");
			}else if(attributeValue.equals(image2)) {
				Assert.assertTrue(attributeValue.equals(image2), "Image Two Found !");
			}else if(attributeValue.equals(image3)) {
				Assert.assertTrue(attributeValue.equals(image3), "Image Three Found !");
			}else {
				System.out.println("No match found" + attributeValue);
			}
		}
	}
}
