package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWHallBookingAddHall;
import pageObjectsPOM.CWLoginPomClass;

public class CWHallBookingAddHallTest extends BaseClass {
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWHallBookingAddHall addhall;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void addHall() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		addhall	= new CWHallBookingAddHall ();
		addhall.clickAddHall();
		addhall.inpAddHall();
		addhall. verifyValidation();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
