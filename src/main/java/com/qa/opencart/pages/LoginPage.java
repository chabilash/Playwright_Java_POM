package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	private String email                  = "//input[@id='input-email']";
	private String password               = "//input[@id='input-password']";
	private String loginButton            = "//input[@value='Login']";
	private String forgottenPasswordLink  = "//div[@class='form-group']//a[normalize-space()='Forgotten Password11']";
	private String logoutLink             = "//a[@class='list-group-item'][normalize-space()='Logout']";
		
	public LoginPage(Page page) {
		this.page = page;
	}
	
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgottenPasswordLinkExists() {
		return page.isVisible(forgottenPasswordLink);
	}
	
	public boolean doLogin(String appEmail, String appPassword) {
		System.out.println("Given credentials are "+appEmail+" & "+appPassword);
		page.fill(email, appEmail);
		page.fill(password, appPassword);
		page.click(loginButton);
		
		if(page.isVisible(logoutLink)) {
			System.out.println("User Logged in Successfully ..");
			return true;
		} else {
			return false;
		}
	}
	
	
}
