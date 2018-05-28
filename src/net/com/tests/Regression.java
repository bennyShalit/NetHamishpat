package net.com.tests;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.Box.Filler;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.com.pageobjects.AddFilesPage;
import net.com.pageobjects.AddGoremPage;
import net.com.pageobjects.FinishPage;
import net.com.pageobjects.HomePage;
import net.com.pageobjects.NetuneyTashlumTikPage;
import net.com.pageobjects.OpenFilePage;
import net.com.pageobjects.TempsecuredLoginPage;
import net.com.pageobjects.ViewDocuments;

public class Regression {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.out.println("--------Start test--------");
		System.out.println("--------------------------");
	
		for(int x=1;x<2;x++){
			WebDriver driver;
			if(x==0)
			{	
				System.setProperty("webdriver.ie.driver","C:\\BennyShalit\\Selenium\\SeleniumDrivers\\MicrosoftWebDriver.exe");
				driver = new InternetExplorerDriver();
				System.out.println("------Edge test--------");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", "C:\\BennyShalit\\Selenium\\SeleniumDrivers\\chromedriver.exe");
				driver =  new ChromeDriver();
				System.out.println("------Chrome test------");
			}
		
		
		//Chrome WebDriver
//		System.setProperty("webdriver.chrome.driver", "C:\\BennyShalit\\Selenium\\SeleniumDrivers\\chromedriver.exe");
//		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");
			
		HomePage homepage = new HomePage(driver);
		homepage.identification2();
		
		TempsecuredLoginPage LoginPage = new TempsecuredLoginPage(driver);
//		LoginPage.login("030388086");
		LoginPage.login2("");
		Thread.sleep(4000);
		homepage.openTik();
		Thread.sleep(5000); 
		
		System.out.println("-------פרטי התיק - תיק אזרחי ללא פטור-------");
		
		Select whereCityFile = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCity")));
//		whereCityFile.selectByValue("5000"); 
		whereCityFile.selectByVisibleText("תל אביב - יפו");
		//to print the value:
		WebElement cityValue = whereCityFile.getFirstSelectedOption();
		System.out.println("עיר: "+cityValue.getText());
		
		Select whereCourt = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCourt")));
		whereCourt.selectByValue("32");
		WebElement courtValue = whereCourt.getFirstSelectedOption();
		System.out.println("בית משפט: "+courtValue.getText());
		
		Select FileProcess = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectProceeding")));
		FileProcess.selectByVisibleText("אזרחי");
		WebElement processValue = FileProcess.getFirstSelectedOption();
		System.out.println("הליך: "+processValue.getText());
		
		Select FileType = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCaseType")));
		FileType.selectByValue("1");
//		WebElement FileTypeValue = FileType.getFirstSelectedOption();
//		System.out.println("סוג תיק: "+FileTypeValue.getText());
		Thread.sleep(2000);
		Select SugInyan = new Select(driver.findElement(By.name("_ctl18:CaseBasicParamSelector1:SelectCaseInterest")));
		SugInyan.selectByValue("41");
//		WebElement SugInyanValue = SugInyan.getFirstSelectedOption();
//		System.out.println("סוג עניין: "+SugInyanValue.getText());
		Thread.sleep(4000);
		
		
		OpenFilePage openfile = new OpenFilePage(driver);
		//////// הזנת סכום תביעה////////
		WebElement numberOnlyField = driver.findElement(By.id("_ctl18_tbClaimAmount"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='1000';", numberOnlyField );
		
		openfile.firstPageOpenNewTik();  //כפתור ייפוי כוח+ הבא
		Thread.sleep(4000);

		WebElement addNitba = driver.findElement(By.id("_ctl0_sidesManipulationUC_sideBTableUC_buttonsGroup_addNewButton"));
		addNitba.click();  //כפתור הוספת גורם - נתבע
		Thread.sleep(3000);
		
		AddGoremPage addGormim = new AddGoremPage(driver); 
//		addGormim.addZihuyDeatils("343110440","שון","כבשון");
		addGormim.addZihuyDeatils2();  //הוספת נתבע
		addGormim.continueNextPage();
		Thread.sleep(2000);

		WebElement addTovea = driver.findElement(By.id("_ctl0_sidesManipulationUC_sideATableUC_buttonsGroup_addNewButton"));
		addTovea.click(); //כפתור הוספת גורם - תובע
		AddGoremPage addGormim2 = new AddGoremPage(driver); 
		driver.findElement(By.id("_ctl0_CaseFactorDefinitionUC1_CaseFactorGeneralTabUC1_tbIdentificationFirstName")).click();
		addGormim2.addZihuyDeatils3();  //הוספת תובע
		addGormim2.continueNextPage();
		Thread.sleep(2000);

		WebElement nextBtn2 = driver.findElement(By.id("_ctl0_ButtonsGroup1_BtnNext"));
		nextBtn2.click(); // המשך למסך צירוף מסמכים
		Thread.sleep(2000);
		
		AddFilesPage addFileP = new AddFilesPage(driver);
		addFileP.insertFilePirsum(); //נתוני איסור פרסום
		Thread.sleep(2000);
		WebElement checkboxAddFileRequestHisayon = driver.findElement(By.id("_ctl0_PrivilageProhibitionDetailsUC1_rbDocumentAttachment"));
		checkboxAddFileRequestHisayon.click();
		
		driver.findElement(By.name("_ctl0:PrivilageProhibitionDetailsUC1:documentFileField:inputFile")).click(); //הוספת מסמך בקשה לחיסיון
		addFileP.addFileProhibitionAdvertising();
		Thread.sleep(2000);
					
		driver.findElement(By.name("_ctl0:DocumentAttachmentUC1:mainDocumentFileField:inputFile")).click(); //הוספת מסמך כתב טענות
		addFileP.addFileExplanationArguments();
		Thread.sleep(2000);
		
		driver.findElement(By.id("_ctl0_ButtonsGroup1_BtnNext")).click(); //כפתור הבא
		/////////////////////////////////////////////  דף נתוני תשלום
		System.out.println("-----");
		Select sugTashlum = new Select(driver.findElement(By.id("_ctl0_feePaymentUC_ddlPaymentType")));
		sugTashlum.selectByValue("6");  //sugTashlum.selectByVisibleText("כרטיס אשראי");
		Select sugCartis = new Select(driver.findElement(By.id("_ctl0_feePaymentUC_ddlCardType")));
		sugCartis.selectByValue("5");
		Select sugIska2 = new Select(driver.findElement(By.id("_ctl0_feePaymentUC_ddlTransactionType")));
		sugIska2.selectByValue("2"); 
		
		NetuneyTashlumTikPage NetuneyTashlumPage = new NetuneyTashlumTikPage(driver);
		NetuneyTashlumPage.detailsOfCard();
		
		Select zihuyName = new Select(driver.findElement(By.id("_ctl0_feePaymentUC_ddlIdentificationType")));
		zihuyName.selectByValue("1");
		Thread.sleep(2000);
		NetuneyTashlumTikPage NetuneyTashlumPage2 = new NetuneyTashlumTikPage(driver);
		NetuneyTashlumPage2.DetailsOfPersonPay();
		////////////////////////////////////////////
		driver.findElement(By.id("_ctl0_ButtonsGroup1_BtnNext")).click(); //כפתור סיום
		Thread.sleep(8000);
		
		FinishPage finishPage = new FinishPage(driver);
		finishPage.finishProcess();
		
		driver.findElement(By.id("_ctl0_Header_WhiteImage")).click();;
		ViewDocuments viewD = new ViewDocuments(driver);
		viewD.enterToTheNewFile();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='browser']/li[18]/a/span")).click(); //פותח תיק נייר
		driver.findElement(By.id("_ctl0_GridDocumentList_row0_ct8_Imagebutton1")).click(); //פותח מסמך
		Thread.sleep(2000);
		

		driver.close();
		driver.quit();
		System.out.println("--------------------------");
		System.out.println("------Test complite-------");
		
		

			
			
			
			
			
			
			
		}
	}
}
