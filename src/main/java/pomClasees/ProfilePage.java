package pomClasees;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

	WebDriver driver;

	@FindBy(xpath="//div[text()='Jyoti ']")
	private WebElement ProfileName;
	
	@FindBy(xpath="//a[@href=\"/account/?rd=0&link=home_account\"]")
	private WebElement MyProfileText;
	
	@FindBy(xpath="//span[text()='Personal Information']")
	private WebElement PersonalInformationText;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement ManageAddressesText;
	
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement AddNewAddressesText;
	

	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> AddressCount;
	  
	//Variables not used
	@FindBy(xpath="(//input[@class='_1w3ZZo _2mFmU7'])[1]")
	private WebElement NameText;
	
	@FindBy(xpath="(//input[@class='_1w3ZZo _2mFmU7'])[2]")
	private WebElement MobNoText;
	
	@FindBy(xpath="(//input[@class='_1w3ZZo _2mFmU7'])[3]")
	private WebElement PincodeText;
	
	@FindBy(xpath="(//input[@class='_1w3ZZo _2mFmU7'])[4]")
	private WebElement LocalityText;
	//==============//=================================
	@FindBy(xpath="//textarea[@class='_1sQQBU _1w3ZZo _1TO48q']")
	private WebElement AddressText;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1JDhFS _1o0c4q _3AWRsL']")
	private WebElement SaveText;
	
	
	
	
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public void WhoreOnProfile() {
		Actions act = new Actions(driver);
		act.moveToElement(ProfileName).perform();;
	}
	
	public void ClickOnMyProfile() {
		MyProfileText.click();
	}
	
	public boolean VerifyUserIsOnProfilePage() {
			try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(PersonalInformationText));
			}catch(Exception e) {
				return false;
			}
			return true;
			
			//String ActualText = PersonalInformationText.getText();
			//System.out.println(ActualText);
			//return ActualText;
	}
	
	public void clickOnManageAddress() {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ManageAddressesText);
		//ManageAddressesText.click();
	}
	
	public void VerifyUserCanAddAddresses(List<String> addressDetails) {
		//ManageAddressesText.click();
		//AddNewAddressesText.click();
		//NameText.sendKeys("Jyoti Nalawade");
		//MobNoText.sendKeys("8975459217");
		//PincodeText.sendKeys("412105");
		//LocalityText.sendKeys("Pune");
		//AddressText.sendKeys("Sambhajinagar,Moshi.");
		//SaveText.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AddNewAddressesText));
		AddNewAddressesText.click();
		
		for(int i=1; i<=4; i++) {
			driver.findElement(By.xpath("//input[@tabindex='"+i+"']")).sendKeys(addressDetails.get(i-1));
		}
		AddressText.sendKeys(addressDetails.get(4));
		SaveText.click();
		
		
		
	}
	
	public int getAddressCount(){
		
		return AddressCount.size();
		
		
	}
	
}
