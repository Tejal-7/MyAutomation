package pageObjectsPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import action.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;

public class MYLOGIN extends BaseClass  {
//			driver.get(prop.getProperty("url"));	
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	// Declaration 
	@FindBy(xpath="//input[@id='username']")
	WebElement emailInput;
	@FindBy(xpath="//input[@id='password']")
	WebElement  inputPassword;
@FindBy(xpath="//div[@id='userview']")
WebElement getCaptcha;
@FindBy(xpath="//input[@id='usercapcha']")
WebElement enterCaptcha;
@FindBy(xpath="//button[@id='submitbutton']")
WebElement loginBtn;
@FindBy(xpath="//i[@class='fa fa-angle-down']")
WebElement dropdownBtn;
@FindBy(xpath="//i[@class='fa fa-ban fa-fw pull-right']")
WebElement logOutBtn;

public MYLOGIN() {
	PageFactory.initElements(driver, this);
}
public void cwlogin() throws InterruptedException {
	Action.type(emailInput,prop.getProperty("username"));
	Action.type(inputPassword, prop.getProperty("password"));
	
	String captchas= getCaptcha.getText();
	System.out.println(captchas);
	Action.type(enterCaptcha, captchas);
	Thread.sleep(1000);
	Action.JSClick(driver, loginBtn);
}
}