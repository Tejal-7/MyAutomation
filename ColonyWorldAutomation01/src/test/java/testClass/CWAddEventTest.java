package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddEvent;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddEventTest extends BaseClass {
	CWLoginPomClass loginCW;
	CWAddEvent addevent;
String user ="adminbrighthomes@colonyworld.com";
String pass="12345";
@BeforeMethod
public void beforeMethod() {
	launchApp();
}
	@Test 
	public void addEvent () throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		addevent = new CWAddEvent();
		addevent.clickAddEvent();
		addevent.inpAddEvent();
	
		
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
