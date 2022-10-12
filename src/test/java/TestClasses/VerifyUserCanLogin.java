package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import BaseClasses.Base1;
import pomClasees.HomePage;
import pomClasees.LoginPage;
import pomClasees.ProfilePage;

public class VerifyUserCanLogin {
	static WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) throws IOException {
		
		driver = Base1.getDriver(browser);
	}
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	@Test
	public void login()throws InterruptedException {
		lp.EnterEmailid();
		lp.EnterPassword();
		lp.ClickOnSubmitBtn();
String prfname = hp.getPrName();
		System.out.println(prfname);
		if (prfname.equals("Jyoti")) {
			System.out.println("Test is Passed");
		}else {
			System.out.println("Test is Fail");
		}
		}
	@AfterMethod
	public void afterMethod(){
		}
	@AfterClass
	public void afterClass() {
		
	}
}
	
  // @Test
//	public void SearchFunctinality() throws InterruptedException {
		//	hp.VerifyUserCanSearchProduct();
		
	
  
	  // 
	  // hp = new HomePage1(driver);
	  //String TextOnPList = hp.ActualText();
	  //if (TextOnPList.contains("Showing 1 –")) {
		//  System.out.println("TestCase is pass");
	 // }else {
		 // System.out.println("TestCase is fail");
	 // }
   

