package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;
import action.Action; 
import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAddEvent extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[7]/a[1]")
	WebElement events  ;
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[5]")
	WebElement  date;
	@FindBy(xpath="//input[@id='eventName']")
	WebElement event_name ;
	@FindBy(xpath="//input[@id='eventDesc']")
	WebElement event_description;
	@FindBy(xpath="//input[@id='addEvent']")
	WebElement addEvent;
	public  CWAddEvent(){
		PageFactory.initElements(driver, this);

	}
		public void clickAddEvent() {
			Action.JSClick(driver, events);
			Log.info("Events is clicked");
			test=ExtentManager.test.info("Events is clicked");
			Action.JSClick(driver, date);
			Log.info("Date is selected");
			test=ExtentManager.test.info("Date is selected");
			
		}
		public void inpAddEvent () {
			Action.type(event_name, "Birthday");
			Log.info("Birthdayy input of event is added ");
			test=ExtentManager.test.info("Birthdayy input of event is added ");
			Action.type(event_description, "Birthday event");
			Log.info("Description is added ");
			test=ExtentManager.test.info("Description is added");
			Action.JSClick(driver, addEvent);
			Log.info("Add event is clicked and event is added succesfully");
			test= ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Add event is clicked and event is added succesfully", ExtentColor.GREEN));
		}
		
		
		
}
