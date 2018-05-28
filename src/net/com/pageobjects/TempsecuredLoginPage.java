package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TempsecuredLoginPage extends BasePage{
	//1. Elements - define the elements on the page
	WebElement IDNumber;
	WebElement btn_Lawyer;
//	WebElement btn_ok;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public TempsecuredLoginPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		IDNumber = driver.findElement(By.xpath(".//*[@id='txt_IDNumber']"));
		btn_Lawyer = driver.findElement(By.xpath(".//*[@id='btn_Lawyer']"));
//		btn_ok = driver.findElement(By.xpath(".//*[@id='returnFocus']"));
	}

	//2. Actions
	
	/*
	 *  Actions methods - implement the Login scenario
	 */
	public void login(String user){
//		btn_Lawyer.click();
//		btn_ok.click();
		IDNumber.clear();
		IDNumber.sendKeys(user);
		btn_Lawyer.click();
	}
	//another way to call action with mark of the action
	public void login2(String user){
		fillText(IDNumber, "030388086");
		Click(btn_Lawyer);
		
	}
}
