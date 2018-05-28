package net.com.tests;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.com.pageobjects.AddBakashaPage;
import net.com.pageobjects.AddFilesPage;
import net.com.pageobjects.BasePage;
import net.com.pageobjects.HomePage;
import net.com.pageobjects.OpenFilePage;
import net.com.pageobjects.TempsecuredLoginPage;


public class SanityNG {
	public WebDriver driver;

//	@BeforeClass
//	public void setup(){
		//Define the driver
//		driver =  new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
//		driver.manage().window().maximize();		
		////////Chrome WebDriver//////////
//		System.setProperty("webdriver.chrome.driver", "C:\\BennyShalit\\Selenium\\SeleniumDrivers\\chromedriver.exe");
//		WebDriver driver =  new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
		/////////Edge WebDriver///////////
//		System.setProperty("webdriver.ie.driver","C:\\BennyShalit\\Selenium\\SeleniumDrivers\\MicrosoftWebDriver.exe");
//		driver = new InternetExplorerDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
//	}
	
	@BeforeClass
	public void setup2(){
	   int browser = 1;
	      switch (browser) {
	         case 1: //Edge
	     		System.setProperty("webdriver.ie.driver","C:\\BennyShalit\\Selenium\\SeleniumDrivers\\MicrosoftWebDriver.exe");
	    		driver = new InternetExplorerDriver();
	    		driver.manage().window().maximize();
	    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
	           break;
	         case 2: //chrome
	     		System.setProperty("webdriver.chrome.driver", "C:\\BennyShalit\\Selenium\\SeleniumDrivers\\chromedriver.exe");
	     		WebDriver driver =  new ChromeDriver();
	     		driver.manage().window().maximize();
	     		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
		   break;
	         default: //firefox
	        	 driver =  new FirefoxDriver();
	        	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     		 driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
	     		 driver.manage().window().maximize();
	           break;
	      }
	      if(browser==1)
	    	  System.out.println("Edge testing");
	      else
	    	  System.out.println("Chrome testing");
	}
	
	@Test
	public void identificationByID() throws InterruptedException{
		HomePage homepage = new HomePage(driver);
		homepage.identification2();
		TempsecuredLoginPage LoginPage = new TempsecuredLoginPage(driver);
		LoginPage.login2(""); 
		Thread.sleep(4000);
	}
	@Test
	public void login() throws InterruptedException{
		HomePage homepage = new HomePage(driver);
		homepage.openTik();
		Thread.sleep(1000);
//		
//		String pageTitle = homepage.getMyTitle();
//		Assert.assertEquals(pageTitle,"פתיחת תיק - פרטי התיק/בא כוח");
//		
//		DetailsOfTheFile(); //ממלא את פרטי התיק
//		Thread.sleep(1000);
//		Select FileType = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCaseType")));
//		FileType.selectByValue("10048");
////		WebElement FileTypeValue = FileType.getFirstSelectedOption();
////		System.out.println("סוג תיק: "+FileTypeValue.getText());	
//		Thread.sleep(2000);
	}
	
	@Test
	public void newBakasha() throws InterruptedException, AWTException{
		////// הגשת בקשה חדשה - תסריט שפיות ארוך //////
		driver.findElement(By.id("_ctl18_Header_WhiteImage")).click();
		Thread.sleep(2000);
		HomePage homepage2 = new HomePage(driver);
		homepage2.goToTik("09", "0218");
		homepage2.newBakasha();	
//		driver.findElement(By.id("_ctl0_Header_UpperMenu1_tdSubmission")).click();  // כפתור הגשות 
//		driver.findElement(By.id("_ctl0_Header_UpperMenu1_NewMotion")).click();  // כפתור בקשה חדשה
		
		String pageTitle = homepage2.getMyTitle();
		Assert.assertEquals(pageTitle,"בקשה חדשה - פרטי הגשה וצירוף מסמך");
		Thread.sleep(1000);
		
		Select sugKvuza = new Select( driver.findElement(By.id("_ctl2_typeGroupDropDownList")));
		sugKvuza.selectByValue("1"); 
		Thread.sleep(1000);
		Select sugBakasha = new Select( driver.findElement(By.id("_ctl2_motionTypeComboBox")));
		sugBakasha.selectByValue("81"); 		
		driver.findElement(By.id("_ctl2_pleaNameTextBox")).sendKeys("קישקוש בלבוש");  //addNewBakash.requestDetailsFirstPage();
//		AddBakashaPage addNewBakash = new AddBakashaPage(driver);
		
		addFile(); //addNewBakash.addfile();
		Thread.sleep(1000);
//		addNewBakash.addMevakshimMashivim();
	}


	
//	@AfterMethod 
//	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
//		if (testResult.getStatus() == ITestResult.FAILURE) 
//		{ 
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
//			FileUtils.copyFile(scrFile, new File("C:/BennyShalit/Selenium/failedShots/" +driver.getTitle()+"-"+".png"));
//			FileUtils.copyFile(scrFile, new File("C:/BennyShalit/Selenium/failedShots/" + testResult.getName() + "-" 
//					+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
//			System.out.println("Screenshot Taken");
//		} 	
//	}	
	

			
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	public void addFile() throws InterruptedException, AWTException{
		driver.findElement(By.id("_ctl2_documentAttachmentUC_mainDocumentFileField_inputFile")).click();
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

		Thread.sleep(2000);
//		driver.findElement(By.id("_ctl2_ButtonsGroup1_BtnNext")).click();
	}
	

}







