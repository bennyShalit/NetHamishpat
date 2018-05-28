package net.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NetuneyTashlumTikPage extends BasePage {
	WebElement ofenBitzuaTashlum;
	WebElement zihuy;
	WebElement zihuyMispar;
	WebElement cardType;
	WebElement cardNumber;
	WebElement expireDate;
	WebElement verificationCode;
	WebElement sugIska;
	WebElement numOfPayments;
	WebElement firstName;
	WebElement lastName;	
	WebElement endBtn;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public NetuneyTashlumTikPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		ofenBitzuaTashlum = driver.findElement(By.id("_ctl0_feePaymentUC_ddlPaymentType"));
		zihuy = driver.findElement(By.id("_ctl0_feePaymentUC_ddlIdentificationType"));
		zihuyMispar = driver.findElement(By.id("_ctl0_feePaymentUC_tbIdentification"));
//		cardType = driver.findElement(By.id("_ctl0_feePaymentUC_ddlCardType"));
		cardNumber = driver.findElement(By.id("_ctl0_feePaymentUC_tbCardNumber"));
		expireDate = driver.findElement(By.id("_ctl0_feePaymentUC_calcExpire"));
		verificationCode = driver.findElement(By.id("_ctl0_feePaymentUC_tbVerificationCode"));
		sugIska = driver.findElement(By.id("_ctl0_feePaymentUC_ddlTransactionType"));
		numOfPayments = driver.findElement(By.id("_ctl0_feePaymentUC_tbNumOfPayments"));
		firstName = driver.findElement(By.name("_ctl0:feePaymentUC:tbFirstName"));
		lastName = driver.findElement(By.id("_ctl0_feePaymentUC_tbLastName"));
		endBtn = driver.findElement(By.id("_ctl0_ButtonsGroup1_BtnNext"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */
	public void DetailsOfPayment(){
		System.out.println("--פרטי תשלום--");
		
		Select sugTashlum = new Select(ofenBitzuaTashlum);
		sugTashlum.selectByValue("6"); 
//		sugTashlum.selectByVisibleText("כרטיס אשראי");
		//to print the value:
		WebElement sugTashlumValue = sugTashlum.getFirstSelectedOption();
		System.out.println("סוג תשלום: "+sugTashlumValue.getText());
		
		Select sugCartis = new Select(cardType);
		sugCartis.selectByValue("5");
		WebElement sugCartisValue = sugCartis.getFirstSelectedOption();
		System.out.println("סוג כרטיס: "+sugCartisValue.getText());
		
		Select sugIska2 = new Select(sugIska);
		sugIska2.selectByValue("2"); 
		WebElement sugIskaValue = sugIska2.getFirstSelectedOption();
		System.out.println("סוג עסקה: "+sugIskaValue.getText());	
	}
	public void detailsOfCard(){
		fillText(cardNumber, "375511291232182");
		fillText(expireDate, "1218");
		fillText(verificationCode, "123");
		fillText(numOfPayments, "3");
	}
	public void DetailsOfPersonPay(){	
		WebElement numberZihuy = driver.findElement(By.id("_ctl0_feePaymentUC_tbIdentification"));
		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		jsExecutor2.executeScript("arguments[0].value='022222222228';", numberZihuy );
		fillText(firstName, "ג'ון");
		fillText(lastName, "סנואו");
	}
	public void endProsses(){
		Click(endBtn);
	}
	
}


	


