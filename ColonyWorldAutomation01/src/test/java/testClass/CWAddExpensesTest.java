package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddExpenses;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddExpensesTest  extends BaseClass {
	CWAddExpenses expense;
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test 
	public void addExpense () throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		expense	= new CWAddExpenses ();	
		expense.clickAddExpenses();
		expense.inpAddExpenses();
		expense.inpdate();
		expense.clickinpDate();
		expense.clickRemark();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}


