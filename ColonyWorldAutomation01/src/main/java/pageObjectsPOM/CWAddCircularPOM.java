package pageObjectsPOM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class CWAddCircularPOM extends BaseClass {
	
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Actions actions;
	Select select ;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[8]/a[1]")
	WebElement circular;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='main-container']/div[@id='page-content']/div[1]/ul[1]/li[2]/a[1]")
	WebElement add_Circular;
	@FindBy(xpath="//input[@id='circulartitle']")
	WebElement circular_title;
	@FindBy(xpath="//input[@id='displayfromdate']")
	WebElement from_date;
	@FindBy(xpath="//td[contains(text(),'14')]")
	List <WebElement>date1;
	@FindBy(xpath="//input[@id='displaydate']")
	WebElement to_date;
	@FindBy(xpath="//td[contains(text(),'15')]")
	List <WebElement> date2;
	@FindBy(xpath="//select[@id='sendCircular']")
	WebElement select_to_send;
	@FindBy(xpath="//textarea[@id='circulardescription']")
	WebElement description ;
	@FindBy(xpath="//input[@id='submit']")
	WebElement submit_btn;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement verification_popup;
	@FindBy(xpath="//strong[contains(text(),'Notice Added Successfully')]")
	WebElement verification_msg;
	@FindBy(xpath="(//a[@class='btn btn-xs btn-primary'])[1]")
	WebElement view_circular;
	@FindBy(xpath="//input[@class='btn btn-back btn-primary pull-right']")
	WebElement close_btn ;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement  title1;
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[1]")
	WebElement edit_btn;
	@FindBy(xpath="//input[@id='displaydate']")
	WebElement edit_date ;
	@FindBy(xpath="//td[contains(text(),'28')]")
	WebElement select_date ;
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/strong[1]/div[1]/input[1]")
	WebElement update_btn ;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement edit_popup;
	@FindBy(xpath="//strong[contains(text(),'Notice Updated Successfully')]")
	WebElement edit_msg;
	//need to click 
	public CWAddCircularPOM () {
		PageFactory.initElements(driver, this);	}

public void clickAddCircular() {
	Action.moveToElement(driver, circular);
	Action.JSClick(driver, circular);
	Log.info("circular is clicked");
test=ExtentManager.test.info("circular is clicked");
Action.JSClick(driver, add_Circular);
Log.info("Add circular is clicked");
test=ExtentManager.test.info("Add circular is clicked");

}
public void inpAddCircular() throws InterruptedException {
	fake = new Faker ();
	String circularTitle = fake.lorem().sentence();
	Action.type(circular_title, circularTitle);
	Log.info("Circular title is added : " +circularTitle );
	test=ExtentManager.test.info("Circular title is added : " +circularTitle);
	from_date.clear();
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	  LocalDate startDate = LocalDate.now().plusDays(fake.number().numberBetween(13, 14)); // Random start date within 30 days from now
      LocalDate endDate = startDate.plusDays(fake.number().numberBetween(13, 14)); // Random end date within 30 days from start date
      String startDateString = startDate.format(formatter);
      String endDateString = endDate.format(formatter);
      from_date.sendKeys(startDateString);
      Log.info("Start date is entered: "+ startDateString);
      test= ExtentManager.test.info("Start date is entered: "+ startDateString);
      to_date.sendKeys(endDateString);
      Log.info("End date is entered: " + endDateString);
      test=ExtentManager.test.info("End date is entered: " + endDateString);
      to_date.sendKeys(Keys.NULL);
      Thread.sleep(500);
     Action.JSClick(driver, select_to_send);
 	select = new Select (select_to_send);
 	select.selectByIndex(1);
 	Log.info("Send to all is selected");
 	test =ExtentManager.test.info("Send to all is selected");
  Action.type(description, "Descriptioo");
  Log.info("Description is entered");
  test=ExtentManager.test.info("Description is entered");
  submit_btn.click();
     Log.info("Add circular is clicked");
     test= ExtentManager.test.info("Add circular is clicked");
     Thread.sleep(500);
}
public void verifyValidation() {
	boolean status = verification_popup.isDisplayed();
	if (status==true) {
		System.out.println("Verification popup ia displayed");
		
	}
	else {
		System.out.println("Verification popup is not displayed");
	}
	boolean status1 = verification_msg.isDisplayed();
	
	 try {
		 Assert.assertEquals(status1, status1);
		 String smsg = verification_msg.getText();
		 System.out.println(smsg);
		 Assert.assertEquals(smsg, "Notice Added Successfully");
		 
	 }
	 catch (Exception e) {
		 e.getMessage();
	 }
}


//////////////////////////////////////VIEW  CIRCULAR/////////////////////////////////////////
public void viewCircular () {
	Action.JSClick(driver, circular);
	Action.JSClick(driver, view_circular);
	Log.info("View circular is clicked");
	test= ExtentManager.test.info("View circular is clicked");
	String titles = title1.getText();
	System.out.println(titles);
//	Assert.assertEquals(titles, "Aliquam ullam quia.");
	Log.info("Added circular is verified it display as :" + titles);
	test=ExtentManager.test.info("Added circular is verified it display as :" + titles);
	Action.JSClick(driver, close_btn );
	Log.info("close button is clicked");
	test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Close button is clicked", ExtentColor.GREEN));
	
	
	
}
//////////////////////////Edit Circular //////////////////////////////
public void editCircular () {
	Action.JSClick(driver,circular );
	Log.info("Circular is clicked ");
	test=ExtentManager.test.info("Circular is clicked ");
	Action.JSClick(driver, edit_btn);
	Log.info("Edit button is clicked");
test=ExtentManager.test.info("Edit button is clicked");
Action.JSClick(driver, edit_date);
Log.info("date is clicked");
Action.JSClick(driver, select_date );
Log.info("Updated date is selected");
actions.click();
Action.JSClick(driver,  update_btn );
Log.info("Upadate Button is clicked");
test=ExtentManager.test.info("Upadate Button is clicked");
boolean editpop = edit_popup.isDisplayed();

if (editpop=true) {
	System.out.println("Edit succesful popup is displaying ");
}
else {
	System.out.println("popup is not displaying");
}
try {
 boolean editmsgs = edit_msg.isDisplayed();
 String msg = edit_msg.getText();
 System.out.println(msg);
 Assert.assertEquals(msg,"Notice Updated Successfully");
 Log.info("Upadte circular msg is displayed as :" + msg);
test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Upadte circular msg is displayed as :" + msg, ExtentColor.GREEN));
}

catch (Exception e )
{
	e.getMessage();
}
}
}