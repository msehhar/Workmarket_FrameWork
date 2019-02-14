package com.App.Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.App.Utilities.CONSTANTS;
import com.App.PageObjects.HomePage;
import com.App.Utilities.BaseFunctions;

public class SmokeTest {
	public BaseFunctions basefunction;
	public HomePage homePage;
		
	@BeforeTest
	public void setup(){
		basefunction = new BaseFunctions();
		homePage = new HomePage();
	}
	
	@BeforeMethod
	public void startDriver(){
		basefunction.startDriver();
	}
	
	@Test
	public void accountRegistration(){
		basefunction.openURL(CONSTANTS.URL);
		homePage.registerAccount();
		assertTrue(homePage.verifyRegistration());			
	}
	
	@Test
	public void testRowSearch(){
		basefunction.openURL(CONSTANTS.URL2);
		homePage.login();
		System.out.println(homePage.getSearchRowCount(homePage.getSearchPageCount()));
	}
	
	@AfterMethod
	public void stopDriver(){
		basefunction.stopDriver();
	}
}
