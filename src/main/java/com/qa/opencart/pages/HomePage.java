package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
//	1.String Locators - Object Repository
	private String search                            = "div#search input";
	private String searchIcon                        = "div#search button";
	private String searchPageHeader                  = "div#content h1";
	private String loginLink                         = "//a[normalize-space()='Login']";
	private String myAccountLink                     = "//span[normalize-space()='My Account']";
	
	//Constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	//Actions on the page
	public String getHomePageTitle() {
		String pageTitle = page.title();
		System.out.println("Page Title is :" + pageTitle);
		return pageTitle;
	}
	
	public String getHomePageURL() {
		String pageURL = page.url();
		System.out.println("Page URL is :"+ pageURL);
		return pageURL;
	}
	
	public String doSearch(String prodName) {
		page.fill(search, prodName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		System.out.println("Search Header is :" + header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	 
	

}
