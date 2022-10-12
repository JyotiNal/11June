package TestClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.Base1;
import pomClasees.HomePage;
import pomClasees.LoginPage;
import pomClasees.ProfilePage;


public class VerifyUserCanAddAddress {

	static WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;
	String oldAddressCount;
	String newAddressCount;
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) throws IOException {
		
		driver = Base1.getDriver(browser);
	}
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	@Test(priority =1)
	public void VerifyUserCanOpenProfilePage() {
		pp.WhoreOnProfile();
		pp.ClickOnMyProfile();
		boolean CorrectText =pp.VerifyUserIsOnProfilePage();
		//if(CorrectText) {                        
			//System.out.println("Test is Passed");
		//}
		//else {
			//System.out.println("Test is failed");
		//}
		Assert.assertTrue(CorrectText);            //We can add assert instead of if-else
	   oldAddressCount =String.valueOf(pp.getAddressCount());
	   System.out.println(oldAddressCount);
	
	}
	@DataProvider(name="addressData")
	public Object[][] getData() {
	Object[][] k = {{"Akshay", "8956235623","413512","Nanded Road", "B-22, A NandedRoadpune"}, {"Sneha","7845124512", "411023", "Warje", "A-32, B WarjeRoadshivaji nagar"}};
		return k;}
	
	@Test(priority=2, dataProvider="addressData")
	public void VerifyThatUserCanAddAddress(String name, String phone, String pincode, String locality, String fullAddress) {
		
		pp.clickOnManageAddress();
		
		List<String> addressDetails = Arrays.asList(name, phone, pincode, locality, fullAddress);
		pp.VerifyUserCanAddAddresses(addressDetails);
		
		String newAddressCount = String.valueOf(pp.getAddressCount());
		System.out.println(newAddressCount);
		boolean isCountMatching= newAddressCount.equals(oldAddressCount);
		
		Assert.assertFalse(isCountMatching);
		
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		Base1.unloadDriver();
	}
	   

}
