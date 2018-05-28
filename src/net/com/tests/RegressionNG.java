package net.com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import net.com.pageobjects.HomePage;
import net.com.pageobjects.IturTikimLefiMisparTikMakor;
import net.com.pageobjects.OpenFilePage;
import net.com.pageobjects.TempsecuredLoginPage;

public class RegressionNG {

	public WebDriver driver;
	
	@BeforeClass
	public void setup(){
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
	
	///////תסריט - בדיקת תיקיית תיקים קשורים באתר לאחר קשירה של תיק חיצוני במזכירות///////
	@Test
	public void identificationByID() throws InterruptedException{
		HomePage homepage = new HomePage(driver);
		homepage.identification2();
		TempsecuredLoginPage LoginPage = new TempsecuredLoginPage(driver);
		LoginPage.login2(""); 
		Thread.sleep(4000);
//		homepage.iturTik();	
	}
	@Test
	public void iturTikMakorLefiTikHotzlap() throws InterruptedException{
		HomePage homepage = new HomePage(driver); 
//		homepage.identification2(); //כניסת בא כוח
//		TempsecuredLoginPage LoginPage = new TempsecuredLoginPage(driver);
//		LoginPage.login2(""); //חיבור עם יוזר עו"ד
//		Thread.sleep(4000);
		homepage.iturTik();	
		
		String pageTitle = homepage.getMyTitle();
		Assert.assertEquals(pageTitle,"איתור תיקים לפי מספר תיק מקור (חיצוני לבית משפט)");
		Thread.sleep(2000);
		IturTikimLefiMisparTikMakor iturTikMakor = new IturTikimLefiMisparTikMakor(driver);
		iturTikMakor.itur("3", "12341111");
//		iturTikMakor.itur1();
//		driver.findElement(By.name("ExternalCaseNumber")).sendKeys("12341111");
		driver.findElement(By.id("buttonsGroup_searchButton")).click();
		Thread.sleep(2000); 
		waitForPageLoaded();
		driver.findElement(By.id("buttonsGroup_searchButton")).click();
		Thread.sleep(2000);
		WebElement numtT =	driver.findElement(By.className("SearchResultsDGSearchResultsDGrt1Bc"));
		getT(numtT);
		String misparTikPnimiText =	driver.findElement(By.className("SearchResultsDGSearchResultsDGrt1Bc")).getText(); //קישור למספר תיק פנימי
		Assert.assertEquals(misparTikPnimiText,"148-12-17");
		System.out.println("נתוני התיק תקינים - תיק פנימי מספר 148-12-17 קשור לתיק חיצוני הוצל'פ 12341111");	
		Thread.sleep(3000);
				
//		driver.findElement(By.id("header_GoHomeCell")).click(); // מעבר למסך הבית
//		driver.navigate().refresh();		
//		driver.findElement(By.id("buttonsGroup_clearButton")).click(); //כפתור נקה
	}
		
//	@Test
//	public void iturTikMaatzarimLefiMisparTikMakor_PA() throws InterruptedException {
//		HomePage homepage = new HomePage(driver);
//		homepage.iturTik();
//		IturTikimLefiMisparTikMakor iturTikMakor = new IturTikimLefiMisparTikMakor(driver);
//		iturTikMakor.test("פלא", "12123333");
//		iturTikMakor.itur2();
//		driver.findElement(By.name("ExternalCaseNumber")).sendKeys("12123333");
//		driver.findElement(By.id("buttonsGroup_searchButton")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("buttonsGroup_searchButton")).click();
//		Thread.sleep(2000);
//		String misparTikPnimiText = "7-01-18";
//		Assert.assertEquals(misparTikPnimiText,"7-01-18");
//		System.out.println("נתוני התיק תקינים - תיק פנימי מספר 7-01-18 קשור לתיק חיצוני הוצל'פ 12341111");
//		Thread.sleep(4000);
//	}
	
	@Test   //iturTikMakorLefiTikMAkor-PELE
	public void testBenny() throws InterruptedException{
		IturTikimLefiMisparTikMakor iturTikMakor = new IturTikimLefiMisparTikMakor(driver);
		iturTikMakor.itur("2", "12123333");
//		iturTikMakor.itur2();
//		driver.findElement(By.name("ExternalCaseNumber")).sendKeys("12123333");
		driver.findElement(By.id("buttonsGroup_searchButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("buttonsGroup_searchButton")).click();
		waitForPageLoaded();
		WebElement numtT =	driver.findElement(By.className("SearchResultsDGSearchResultsDGrt1Bc"));
		getT(numtT);
		String misparTikPnimiText =	driver.findElement(By.className("SearchResultsDGSearchResultsDGrt1Bc")).getText(); //קישור למספר תיק פנימי
		Assert.assertEquals(misparTikPnimiText,"7-01-18");
		System.out.println("נתוני התיק תקינים - תיק פנימי מספר 7-01-18 קשור לתיק חיצוני פלא 12123333");	
		Thread.sleep(3000);
		driver.findElement(By.id("header_GoHomeCell")).click(); // 
	}
	
//	@Test
//	public void z_hagashatBakashTikSagur() throws InterruptedException{
//		HomePage homepage = new HomePage(driver);
//		homepage.goToTik("11", "1117");
//	}
		
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	
	 public void waitForPageLoaded() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	            wait.until(expectation);
	        } catch (Throwable error) {
	            Assert.fail("Timeout waiting for Page Load Request to complete.");
	        }
	 }	 
	 public String getT(WebElement el){
			try
			{
			JavascriptExecutor js=(JavascriptExecutor)driver; 
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", el);
			el.clear();
			}
			catch(Exception err){
//				System.out.println("");
			}
			return el.getText();
	}
	
}

