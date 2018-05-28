package net.com.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {

	WebDriver driver;

	public BasePage (WebDriver driver){
		this.driver = driver;
	}

	public void fillText(WebElement el,String text){
		try
		{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		el.clear();
		el.sendKeys(text);
		}
		catch(Exception err){
			System.out.println("element is not exist");
		}
		
	}

	public void Click(WebElement el){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", el, "border: 2px solid green;");
		el.click();
	}

	public String getText(WebElement el){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", el, "border: 2px solid blue;");
		return el.getText();
	}


	public String getMyTitle(){
		sleep(1);
		return driver.getTitle();
	}

	public void sleep(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

