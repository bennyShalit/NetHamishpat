package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class IturTikimLefiMisparTikMakor extends BasePage{

	WebElement sugTikMakor;
	WebElement misparTikMakor;
	WebElement btnIshur;


	 //1. Constructor  

	public IturTikimLefiMisparTikMakor(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements 
		sugTikMakor = driver.findElement(By.name("ExternalCaseTypeIDDropDown"));
		misparTikMakor = driver.findElement(By.name("ExternalCaseNumber"));
		btnIshur = driver.findElement(By.id("buttonsGroup_searchButton"));

	}								

	//2. Actions
	public void itur1() {
		Select sugTik = new Select(sugTikMakor); 
		sugTik.selectByValue("3");	
//		fillText(misparTikMakor, "12341111");
//		Click(btnIshur);
	}
	public void itur2(){
		Select sugTik2 = new Select(sugTikMakor); 
		sugTik2.selectByVisibleText("פלא");
//		fillText(misparTikMakor, "12123333");
//		Click(btnIshur);
	}
	public String itur(String type,String num){
		Select sugTik2 = new Select(sugTikMakor); 
//		sugTik2.selectByVisibleText(type);
		sugTik2.selectByValue(type);	
		fillText(misparTikMakor,num);
		return num;
	}
	

}
