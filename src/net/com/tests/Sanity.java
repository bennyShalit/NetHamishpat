package net.com.tests;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import net.com.pageobjects.AddFilesPage;
import net.com.pageobjects.AddGoremPage;
import net.com.pageobjects.FinishPage;
import net.com.pageobjects.HomePage;
import net.com.pageobjects.OpenFilePage;
import net.com.pageobjects.TempsecuredLoginPage;
import net.com.pageobjects.ViewDocuments;

public class Sanity {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.out.println("--------Start test--------"); ////תסריט פתיחת תיק מרחוק/////
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
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://192.168.132.1/NGCS.Web.Site/HomePage.aspx");  //אתר רגיל
//		driver.get("http://192.168.132.11/NGCS.Web.Secured/TempsecuredLogin.aspx");  //אתר מאובטח
			
		HomePage homepage = new HomePage(driver);
//		driver.findElement(By.linkText("כרטיס חכם")).click();
		homepage.identification2();	
		TempsecuredLoginPage LoginPage = new TempsecuredLoginPage(driver);
		
//		LoginPage.login("030388086");
		LoginPage.login2(""); //התחברות עם שימוש ב css
		Thread.sleep(4000);


		
		

		driver.close();
		driver.quit();
		System.out.println("--------------------------");
		System.out.println("------Test complite-------");
		}
	}
}



