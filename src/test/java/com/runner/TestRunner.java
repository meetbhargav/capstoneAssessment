package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Bhargav\\eclipse-workspace\\capstoneAssessment\\src\\test\\resources\\Features",
				glue ={"com.capstonesteps"}, 
				plugin = {"pretty","html:target/cucumber-reports.html", "json:target/json_cucumber.json"},
				monochrome = true,
				publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

/* public class TestRunner extends AbstractTestNGCucumberTests{
 * 
 * @Override
 * @DataProvider
 * public object[][] scenario(){
 * 		return super.scenarios();
 * }
 * 	
 * }
 * 
 * */
