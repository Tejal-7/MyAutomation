package pageObjectsPOM;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import action.Action;
import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAddExpenses extends BaseClass  {
	
	//Society Expenses Created Successfully.
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Actions actions;
	Select select ;
@FindBy(xpath="(//i[@class='fa fa-angle-right sidebar-nav-indicator'])[13]")
WebElement expenses ;
@FindBy(xpath="//a[normalize-space()='Add Expenses']")
WebElement add_expenses ;
@FindBy(css ="#name")
WebElement expenses_head  ;
@FindBy(css="#expenditure")
WebElement expenditure;
@FindBy(css="#date")
WebElement  dates ;
@FindBy(xpath="//table [@class=' table-condensed']")
WebElement table1;
List<WebElement> dateElements ;

@FindBy(xpath="//td[contains(text(),'31')]")
WebElement date_to_select ;
@FindBy(css="#remark")
WebElement remarks;
@FindBy(css="#addExpenses")
WebElement add_expense_btn ;
@FindBy(xpath="(//div[@class='modal-content'])[4]")
WebElement verification_popup;
@FindBy(xpath="//strong[normalize-space()='Society Expenses Created Successfully.']")
WebElement verificatin_text ;
@FindBy(css="button.btn.btn-primary.btn-sm")
WebElement close;
public  CWAddExpenses() {
	PageFactory.initElements(driver, this);
	
}
public void clickAddExpenses() {
	 Action.JSClick(driver,  expenses);
	 Log.info("Expenses is clicked succesfully");
	 test=ExtentManager.test.info("Expenses is clicked succesfully");
	 Action.JSClick(driver, add_expenses);
	 Log.info("add expenses is clicked ");
	 test=ExtentManager.test.info("add expenses is clicked ");
	 Action.JSClick(driver, dates );
	
}
public void inpAddExpenses() {
	fake  = new Faker ();
	String feeHeadName = fake.lorem().word();
	Action.type(expenses_head ,feeHeadName );
	Log.info("Head name is added succesfully" + feeHeadName);
	test=ExtentManager.test.info("Head name is added succesfully" + feeHeadName);
	String exp = fake.number().digits(4);
Action.type(expenditure, exp);
Log.info("Expenditure is entered" +  exp);
test=ExtentManager.test.info("Expenditure is entered" +  exp);
}
public WebElement inpdate () {
	 return table1 .findElement(By.xpath("(//td[@class='day'])[29]"));

}
public void clickinpDate() {
	inpdate().click();
}
public void clickRemark() {	
fake = new Faker ();
String commentText = fake.lorem().sentence();
Action.type(remarks, commentText);
Log.info("Remark is added ");
test =ExtentManager.test.info("Remark is added ");
	Action.JSClick(driver, add_expense_btn);
	Log.info("Add expense button is clicked ");
	test=ExtentManager.test.info("Add expense button is clicked ");




}
	
	       


}