package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddGoremPage extends BasePage {
	WebElement tZihuy;
	WebElement shemPrati;
	WebElement shemMishpaha;
	WebElement address;
	WebElement okBtn;
	
	WebElement tZihuyTovea;
	WebElement shemPratiTovea;
	WebElement shemMishpahaTovea;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public AddGoremPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		tZihuy = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbId"));
		shemPrati = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbIdentificationFirstName"));
		shemMishpaha = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbIdentificationLastName"));
		address = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_chkIsAddressNotKnown"));
		okBtn = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_ButtonsGroupUC1_BtnApporve"));
		
		tZihuyTovea = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbId"));
		shemPratiTovea = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbIdentificationFirstName"));
		shemMishpahaTovea = driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbIdentificationLastName"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */
//	public void addZihuyDeatils(String t, String f, String l){
//		tZihuy.sendKeys(t);
//		shemPrati.sendKeys(f);
//		shemMishpaha.sendKeys(l);
//	}
	public void addZihuyDeatils2(){
		fillText(tZihuy, "126112119");
		fillText(shemPrati, "גון");
		fillText(shemMishpaha, "סנואו");
	}
	public void addZihuyDeatils3(){
		fillText(tZihuyTovea, "369024013");
		fillText(shemPratiTovea, "ישראל");
		fillText(shemMishpahaTovea, "ישראלי");
	}
	public void continueNextPage(){
		Click(address);
		Click(okBtn);
	}
	
}
