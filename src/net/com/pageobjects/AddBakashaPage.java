package net.com.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddBakashaPage extends BasePage{
	WebElement sugKvuzaField;
	WebElement sugBakashaField;
	WebElement description;
	WebElement addFile;
	WebElement nextBtn;
	WebElement mevakesh;
	WebElement mashiv;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public AddBakashaPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		sugKvuzaField = driver.findElement(By.id("_ctl2_typeGroupDropDownList"));
		sugBakashaField = driver.findElement(By.id("_ctl2_motionTypeComboBox"));
		description = driver.findElement(By.id("_ctl2_pleaNameTextBox"));
		addFile = driver.findElement(By.id("_ctl2_documentAttachmentUC_mainDocumentFileField_inputFile"));
		nextBtn = driver.findElement(By.id("_ctl2_ButtonsGroup1_BtnNext"));
		mevakesh = driver.findElement(By.id("_ctl0_sidesManipulationWithSelectionUC_sideATableUC_partiesGridEXrt0_L"));
		mashiv = driver.findElement(By.id("_ctl0_sidesManipulationWithSelectionUC_sideBTableUC_partiesGridEXrt0_L"));
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */

	public void requestDetailsFirstPage() {
//		Select sugKvuza = new Select(sugKvuzaField);
//		sugKvuza.selectByValue("1"); 
//		Select sugBakasha = new Select(sugBakashaField);
//		sugBakasha.selectByValue("81"); 	
		fillText(description, "קישקוש בלבוש");	
	}
	public void addfile() throws InterruptedException, AWTException{
		////////////הוסםת מסמך/////////////
		Click(addFile);
		StringSelection ss = new StringSelection("C:\\Users\\bennysh\\Downloads\\מסמך להעלאה לאתר עוד.PDF.sgn");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(3000);
		   // Create object of Robot class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Click(nextBtn);	
	}
	public void addMevakshimMashivim(){
		Click(mevakesh);
		Click(mashiv);
	}

}
