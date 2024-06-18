package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import action.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWHallBookingAddHall extends BaseClass  {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select ;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[22]/a[1]/i[1]")
WebElement hall_booking ;
	@FindBy(xpath="//a[contains(text(),'Add Hall')]")	
WebElement add_hall ;
@FindBy(xpath="//input[@id='name']")
WebElement hall_name;
@FindBy(xpath="//input[@id='charges']")
WebElement charges;
@FindBy(xpath="//input[@id='addHall']")
WebElement add_hall_btn;
@FindBy(xpath="(//div[@class='modal-content'])[3]")
WebElement success_popup ;
@FindBy(xpath="//strong[contains(text(),'Hall Added Successfully .')]")
WebElement success_msg;
public CWHallBookingAddHall() {
	PageFactory.initElements(driver, this);
}
public void clickAddHall() {
	Action.JSClick(driver,hall_booking);
	Log.info("Hall booking is clicked ");
	test=ExtentManager.test.info("Hall booking is clicked");
	Action.JSClick(driver, add_hall);
	Log.info("Add hall is clicked");
	test=ExtentManager.test.info("Add hall is clicked");
}
public void inpAddHall() {
//String []hallName = {"marriage hall", "Community Hall1 ", "Society Play club"};
//for (int i=0; i<hallName.length; i++) {
	//hall_name.sendKeys(String.valueOf(i[0]));
	
fake = new Faker ();
String hallNm = fake.gameOfThrones().city();
Action.type(hall_name, hallNm);
Log.info("Hall name is entered: " + hallNm);
test=ExtentManager.test.info("Hall name is entered: " + hallNm);
charges.sendKeys("70");
Log.info("Charges are entered");
test=ExtentManager.test.info("Charges are entered");
Action.JSClick(driver, add_hall_btn);
Log.info("Add hall button is clicked");
test=ExtentManager.test.info("Add hall button is clicked succesfully");

}
public void verifyValidation() {
	boolean status = success_popup.isDisplayed();
	if (status ==true) {
		System.out.println("Validation popup is displayed");
		Log.info("Validation popup is displaying");
		test=ExtentManager.test.info("Validation popup is displayed");
	}
	else {
		System.out.println("Validtion popup is not displaying");
	}
	boolean status2 = success_msg .isDisplayed();
	String msg = success_msg.getText();
Assert.assertEquals(msg, "Hall Added Successfully .");
Log.info("Hall is added suceefully with success message as :" + msg);
test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Hall is added suceefully with success message as :" + msg, ExtentColor.GREEN));


}



}

        


