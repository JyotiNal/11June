package pomClasees;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


	//Global Variable Driver
	WebDriver driver;
	
	//Private WebElements
	@FindBy(xpath="//div[text()='Jyoti ']")
	private WebElement ProfileName;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement SearchField;
	
	@FindBy(xpath="//div[@class='_2kHMtA']")
	private WebElement ProductList;
	
	@FindBy(xpath="//span[@class='_10Ermr']")
	private WebElement Text;
	
	
	
	//Constructor
		public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
		//Public Methods
	public String getPrName () throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Newtext = wait.until(ExpectedConditions.visibilityOf(ProfileName));
		
		String PName =Newtext.getText();
		return PName;
	}
	
	public void VerifyUserCanSearchProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement NewSearchField = wait.until(ExpectedConditions.visibilityOf(SearchField));
		NewSearchField.click();
		NewSearchField.sendKeys("Samsung");
		NewSearchField.sendKeys(Keys.ENTER);
	
	}
	
	public String ActualText() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ProductList));
		
		String ActualText = Text.getText();
		return ActualText;
	}
	
}
