package net.com.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddFilesPage extends BasePage{
	WebElement checkboxIsurPirsum;
	WebElement finishBtn;
	
	/*
	 * Constructor -  
	 * Initiate the driver by calling the constructor of the parent (BasePage)
	 * 
	 */
	public AddFilesPage(WebDriver d){
		//initialize the driver by calling the parnet's constructor
		super(d);
		//initialize the elements
		checkboxIsurPirsum = driver.findElement(By.id("_ctl0_PrivilageProhibitionDetailsUC1_cbForbidenPublic"));
		finishBtn = driver.findElement(By.id("_ctl0_ButtonsGroup1_BtnNext"));
		
	}								

	//2. Actions
	/*
	 *  Actions methods - implement the Login scenario
	 */

	public void insertFilePirsum() throws InterruptedException{
		Click(checkboxIsurPirsum);
	}
	
	public void addFileProhibitionAdvertising() throws AWTException, InterruptedException {
//	driver.findElement(By.id("__ctl0_PrivilageProhibitionDetailsUC1_documentFileField_inputFile")).click();
	  //Paste the file's absolute path into the File name field of the File Upload dialog box
	 //native key strokes for CTRL, V and ENTER keys
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
	}
	
	public void addFileExplanationArguments() throws AWTException, InterruptedException {
		  //Paste the file's absolute path into the File name field of the File Upload dialog box
		 //native key strokes for CTRL, V and ENTER keys
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
	}

}
