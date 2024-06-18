package testClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.MYLOGIN;

public class MYLOGINTEST extends BaseClass  {
	MYLOGIN login;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void login1() throws InterruptedException {
		login= new MYLOGIN ();
		login.cwlogin();
	}
}
