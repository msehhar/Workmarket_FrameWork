package com.App.PageObjects;

import com.App.Utilities.BaseFunctions;
import com.App.Utilities.CONSTANTS;

public class HomePage extends BaseFunctions{

	public String joinAsIndividual = "//*[@id='landing-page-bucket']/div/div[1]/div[2]/div[2]/div/button/div/div/span";
	public String firstName = "//*[@id='firstname']";
	public String lastName = "//*[@id='lastname']";
	public String registerEmailAddress = "//*[@id='email']";
	public String registerPassword = "//*[@id='password']";
	public String termsAndConditions = "//*[@id='landing-page-bucket']/div/div[2]/div[2]/div/div[5]/div/input";
	public String registerButton = "//*[@id='landing-page-bucket']/div/div[2]/div[2]/footer/div/button/div/div/span";
	public String confirmRegistration = "//*[@id='campaign_landing']/div[1]/h2";
	
	public String loginEmailAddress = "//*[@id='login-email']"; 
	public String loginPassword = "//*[@id='login-password']"; 
	public String loginButton = "//*[@id='login_page_button']/span";   
	public String findTalent = "//*[@id='wm-main-nav']/div/div[1]/div/div/div[2]/div[2]/a/div/div/div";
	public String searchBox = "//*[@id='input-text']";
	public String pageResult = "//*[@id='cart']/div[1]";
	public String keyword = "//*[@id='outer-container']/div/div[2]/div[4]/div/div/div[1]/div[2]/div/div[1]/div";
	public String resultSearch = "//*[@id='search_results']/div";
	public String nextPage = "//*[@id='cart']/div[1]/a[2]";
	
	public int pageSearchCount = 0;
	
	public void registerAccount(){
		clickElement(joinAsIndividual);
		enterText(firstName, CONSTANTS.firstName);
		enterText(lastName, CONSTANTS.lastName);
		enterText(registerEmailAddress, CONSTANTS.registerEmailAddress);
		enterText(registerPassword, CONSTANTS.registerPassword);
		clickElement(termsAndConditions);
		clickElement(registerButton);
	}
	
	public boolean verifyRegistration(){
		if(getText(confirmRegistration).equals("Thank You from CoName_6225")){
			return true;
		}else{
			return false;
		}
	}
	
	public void login(){
		enterText(loginEmailAddress, CONSTANTS.loginEmail);
		enterText(loginPassword, CONSTANTS.loginPassword);
		clickElement(loginButton);
	}
	
	public int getSearchPageCount(){
		clickElement(findTalent);
		enterText(searchBox, CONSTANTS.searchTest);
		searchBoxClick(searchBox);
		hardWait();
		return Integer.parseInt(getAttribute(pageResult, "data-max"));
	}
	
	public int getSearchRowCount(int pageCount){
		int sum = 0;
		for (int i=0; i<pageCount; i++){
			sum += listSize(resultSearch);
			clickElement(nextPage);
			hardWait();
		}
		return sum;
	}
}
