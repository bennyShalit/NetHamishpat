package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenFilePage extends BasePage {
	//1. Elements - define the elements on the page
	WebElement city;
	WebElement court;
	WebElement yepuyKoah;
	WebElement nextBtn1;

	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public OpenFilePage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		city = driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCity"));
		court = driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCourt"));
		yepuyKoah = driver.findElement(By.id("_ctl18_chkPowerOfAttorney"));
		nextBtn1 = driver.findElement(By.id("_ctl18_ButtonsGroup1_BtnNext"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */
//	public void selectInfoForNewFile(String user){
//		fillText(IDNumber, "030388086");
//		Click(btn_Lawyer);	
//	}
	public void DetailsOfTheFile(String process,String type){
		Select whereCityFile = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCity")));
	//	whereCityFile.selectByValue("5000"); 
		whereCityFile.selectByVisibleText("תל אביב - יפו");
		//to print the value:
		WebElement cityValue = whereCityFile.getFirstSelectedOption();
		System.out.println("עיר: "+cityValue.getText());
		
		Select whereCourt = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCourt")));
		whereCourt.selectByValue("32");
		WebElement courtValue = whereCourt.getFirstSelectedOption();
		System.out.println("בית משפט: "+courtValue.getText());
		
		Select FileProcess = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectProceeding")));
		FileProcess.selectByVisibleText(process);
		WebElement processValue = FileProcess.getFirstSelectedOption();
		System.out.println("הליך: "+processValue.getText());
		
		Select FileType = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCaseType")));
		FileType.selectByValue(type);
	//	FileType.selectByValue("10048");
	//	WebElement FileTypeValue = FileType.getFirstSelectedOption();
	//	System.out.println("סוג תיק: "+FileTypeValue.getText());
	}
	
	public void firstPageOpenNewTik() {
		Click(yepuyKoah);
		Click(nextBtn1);
	}

}
