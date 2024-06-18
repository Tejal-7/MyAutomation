package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddCircularPOM;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddCircularTest extends BaseClass  {
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWAddCircularPOM circular ;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test 
	public void addCircular() throws InterruptedException {
		
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		circular =	 new CWAddCircularPOM ();
		circular.clickAddCircular();
		circular.inpAddCircular();
		circular.verifyValidation();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
