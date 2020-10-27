package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpageObj;
	
	@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	 }
	
	@Test(priority=1)
	 public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
	  loginpageObj.enterUserName(DatabasePage.getData("username"));
	  String uName=DatabasePage.getData("username");
	  System.out.println("uername is: "+uName);  
	  Thread.sleep(2000);
	  
	  loginpageObj.enterPassword(DatabasePage.getData("password"));
	  String pass=DatabasePage.getData("password");
	  System.out.println("password is: "+pass);
	  Thread.sleep(2000);
	  loginpageObj.clickSignInButton();
	  
	  takeScreenshotAtEndOfTest();
	 }

}
