package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddCircularPOM;
import pageObjectsPOM.CWLoginPomClass;

public class CWViewirculatTest extends BaseClass {

	CWAddCircularPOM viewcirulcar ;
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test 
	public void viewCir() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
	 viewcirulcar = new 	CWAddCircularPOM();
	 viewcirulcar.viewCircular();
	}
	@AfterMethod 
	public void teardown () {
		driver.quit ();
	}
}
