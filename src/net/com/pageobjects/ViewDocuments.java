package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewDocuments extends BasePage {
	WebElement numberOfTik;
	WebElement numberOfTikYYMM;
	WebElement findFileBtn;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public ViewDocuments(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		numberOfTik = driver.findElement(By.name("Header1:CaseLocatorHeaderUC2:BamaCaseNumberTextBoxHT"));
		numberOfTikYYMM = driver.findElement(By.id("Header1_CaseLocatorHeaderUC2_BamaMonthYearTextBoxHT"));
		findFileBtn = driver.findElement(By.id("Header1_CaseLocatorHeaderUC2_SearchHeaderCaseButton"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */

	public void enterToTheNewFile(){
//		FinishPage f = new FinishPage(driver);
//		String strMyNum = String.valueOf(f.myNum);
//		fillText(numberOfTik, strMyNum);
		fillText(numberOfTik, "42");
		fillText(numberOfTikYYMM, "1117");
		Click(findFileBtn);	
	}
}