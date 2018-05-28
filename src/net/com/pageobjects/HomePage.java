package net.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	@FindBy(xpath=".//*[@id='btnEnterIn']")
	WebElement enterBtn;
	@FindBy(id="Header1_UpperMenu1_tdCaseOpenning")
	WebElement ptihatTik;
	@FindBy(id="returnFocus")
	WebElement confirm_btn;
	@FindBy(className="btn btn-primary dropdown-toggle")
	WebElement iturTik;
	@FindBy(id="Header1_UpperMenu1_btnExternalSearchCases")
	WebElement tikimLefiMisparMakor;
	@FindBy(id="Header1_CaseLocatorHeaderUC2_BamaCaseNumberTextBoxHT")
	WebElement numberTik;
	@FindBy(id="Header1_CaseLocatorHeaderUC2_BamaMonthYearTextBoxHT")
	WebElement monthYearTik;
	@FindBy(id="Header1_CaseLocatorHeaderUC2_SearchHeaderCaseButton")
	WebElement searchTikBtn;
	@FindBy(id="_ctl0_Header_UpperMenu1_tdSubmission")
	WebElement hagashotBtn;
	@FindBy(id="_ctl0_Header_UpperMenu1_NewMotion")
	WebElement bakashaHadasha;
			
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void identification(){
		enterBtn.click();
	}
	//another way to call action with mark of the action
	public void identification2(){
		Click(enterBtn);
	}
	public void openTik(){
		Click(ptihatTik);
		Click(confirm_btn);
	}
	public void iturTik(){
		Click(iturTik);
		Click(tikimLefiMisparMakor);
	}
	public void goToTik(String numTik, String dateTik) throws InterruptedException{
		fillText(numberTik, numTik);
		fillText(monthYearTik, dateTik);
		Click(searchTikBtn);
		Thread.sleep(1000);
	}
	public void newBakasha() throws InterruptedException{
		Click(hagashotBtn);
		Click(bakashaHadasha);
		Thread.sleep(2000);
	}
}
