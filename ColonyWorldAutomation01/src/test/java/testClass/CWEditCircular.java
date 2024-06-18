package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddCircularPOM;
import pageObjectsPOM.CWLoginPomClass;

public class CWEditCircular extends BaseClass {
	CWAddCircularPOM editCir;
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test 
	public void editCircular() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
	editCir = new 	CWAddCircularPOM ();
	editCir.editCircular();
	}
	@AfterMethod 
	public void teardown () {
		driver.quit ();
	}
}
