package sitepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private Wait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//input[@name='email']")
	WebElement inputBoxEmail;

	@CacheLookup
	@FindBy(xpath = "//div[@id='auth-error-message-box']/div/div/ul/li/span")
	WebElement errorMessage;

	@CacheLookup
	@FindBy(xpath = "//input[@id='continue']")
	WebElement buttonContinue;

	@CacheLookup
	@FindBy(xpath = "//h1")
	WebElement heading;
	// h1

	/**
	 * This function gets heading from the page
	 * 
	 * @param none
	 * @author sandeep
	 * @return String
	 * 
	 */
	public String getHeadingOnPage() {
		return heading.getText();

	}

	/**
	 * This function inputs text into email field
	 * 
	 * @param String inputText
	 * @author sandeep
	 * @return Void
	 * 
	 */
	public void inputTextOnEmailBox(String inputText) {
		inputBoxEmail.sendKeys(inputText);
	}

	/**
	 * This function clicks on Continue Button
	 * 
	 * @author sandeep
	 * @return Void
	 * 
	 */
	public void clickOnContinueButton() {
		buttonContinue.click();
	}

	/**
	 * This function returns error text
	 * 
	 * @author sandeep
	 * @return Void
	 * 
	 */
	public String getErrorMessage() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMessage));
		return errorMessage.getText();
	}

}
