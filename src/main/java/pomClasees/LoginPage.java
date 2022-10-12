package pomClasees;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//webElements, constructor and public methods
		@FindBy(xpath="(//input[@type='text'])[2]")
		private WebElement emailID;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement loginBth;
				
				
				public LoginPage(WebDriver driver) {
					PageFactory.initElements(driver, this);
					
				}
				
				public void EnterEmailid () {
					emailID.sendKeys("8975459217");
				}
				
				public void EnterPassword() {
					password.sendKeys("Jyoti@1234");
				}
				
				public void ClickOnSubmitBtn() {
					loginBth.click();
				}
}
