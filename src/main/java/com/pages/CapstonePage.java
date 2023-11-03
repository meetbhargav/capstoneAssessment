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
	}
	
	public void compareImages() {
		List<WebElement> images = driver.findElements(imagesLocator);
		
		/*WebElement images1 = images.get(0);
		String a = images1.getAttribute("src");
		System.out.println(a);*/
		
		
		for(WebElement element:images) {
			String attributeValue = element.getAttribute("src");
			
			if(attributeValue.equals(image1)) {
				Assert.assertEquals(attributeValue, image1);
				System.out.println("Image 1 : "+attributeValue);
			}else if(attributeValue.equals(image2)) {
				Assert.assertEquals(attributeValue, image2);
				System.out.println("Image 2 : "+attributeValue);
			}else if(attributeValue.equals(image3)) {
				Assert.assertEquals(attributeValue, image3);
				System.out.println("Image 3 : "+attributeValue);
			}else {
				System.out.println("No match found" + attributeValue);
			}	
		}
	}
}
