package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage extends BasePage {
	WebElement detailsOfTheNewFileThatOpened;
	WebElement approveBtn;
	int myNum = 0;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public FinishPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		detailsOfTheNewFileThatOpened = driver.findElement(By.id("_ctl0_resultLabel"));
		approveBtn = driver.findElement(By.id("_ctl0_confirmButton"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */

	public void finishProcess(){
		String t = getText(detailsOfTheNewFileThatOpened);
		System.out.println("מידע על התיק: "+t);
//	    System.out.println(t.substring(14)); //ידפיס את הסטרינג ממיקום מספר
	    String numF = t.substring(14);  //ידפיס את הסטרינג ממיקום מספר 14
//	    int myNum = 0;
	   	myNum = Integer.parseInt(numF.replaceAll("[\\D]", ""));
	    System.out.println("מספר תיק: "+myNum);
	    Click(approveBtn);
	}
//    public Integer getMyValue() {
//        return myNum;
//      }
}
