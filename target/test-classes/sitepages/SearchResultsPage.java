package sitepages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	private WebDriver driver;
	private Wait wait;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//span[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']/h1/div/div/div/div/span")
	WebElement searchResultTopBar;
	
	@CacheLookup
	@FindBy(xpath="//section[@aria-label='4 Stars & Up']")
	WebElement fourStarReview;
	
	@CacheLookup
	@FindBy(xpath="(//span[@data-component-type='s-product-image']/a)[2]")
	WebElement firstProduct;
	
	@CacheLookup
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	WebElement productPrice;
	
	@CacheLookup
	@FindBy(xpath="(//span[@id='contextualIngressPtLabel']/ancestor::a)[2]")
	WebElement deliveryLocation;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='GLUXZipUpdateInput']")
	WebElement pinCodeInputBox;
	
	@CacheLookup
	@FindBy(xpath="//span[@id='GLUXZipUpdate']/span/input")
	WebElement applyButtonOnPinCodeBox;
	
	@CacheLookup
	@FindBy(xpath="(//div[@id='contextualIngressPtLabel_deliveryShortLine'])[2]")
	WebElement deliverToPinCodeAfterSelection;
	
	@CacheLookup
	@FindBy(xpath="(//iframe)[5]")
	WebElement compareProductFrame;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='sp_hqp_shared']/div/div/a")
	WebElement compareProductLink;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addToCartLink;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='attach-added-to-cart-alert-and-image-area']//h4")
	WebElement addedToCartText;
	
	@CacheLookup
	@FindBy(xpath="//a[@id='attach-close_sideSheet-link']")
	WebElement closeLinkOnAddedToCartPane;
	
	@CacheLookup
	@FindBy(xpath="(//div[@id='prodDetails']//h1)[1]")
	WebElement technicalDetailsSection;
	
	/**
	 * This function click on Amazon pay on the navigation
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public String getSearchResultTopBarText() {
		return searchResultTopBar.getText();
	}
	
	/**
	 * This function click 4 stars review
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void selectFourStarReview() {
		fourStarReview.click();
	}
	
	/**
	 * This function click on first product
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void selectFirstProduct() {
		firstProduct.click();
	}
	
	/**
	 * This function get the price
	 * @param none
	 * @author sandeep
	 * @return String price
	 * 
	 */
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	/**
	 * This function clicks on select delivery location
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void clickOnDeliveryLocation() {
		deliveryLocation.click();
	}
	
	/**
	 * This function enters pin code into the box
	 * @param String pinCode
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void enterPinCodeIntoBox(String pinCode) {
		pinCodeInputBox.sendKeys(pinCode);
	}
	
	/**
	 * This function clicks on Apply Button on pind code box
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void clickApplyOnPinCodeBox() {
		applyButtonOnPinCodeBox.click();
	}
	
	/**
	 * This function returns the text from deliver to location
	 * @param none
	 * @author sandeep
	 * @return String Text
	 * 
	 */
	public String getDeliverToLocationText() {
		return deliverToPinCodeAfterSelection.getText();
	}
	
	/**
	 * This function clicks on compareproduct
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnCompareProductwithSponsoredProduct() {
		driver.switchTo().frame("ape_Detail_hero-quick-promo_Desktop_iframe");
		compareProductLink.click();

	}
	
	/**
	 * This function clicks on add To Cart Link
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnAddToCartLink() {
		addToCartLink.click();
	}
	
	/**
	 * This function returns added to Cart Text
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public String getAddedToCartText() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(addedToCartText, "Added to Cart"));
		return addedToCartText.getText();
	}
	
	/**
	 * This function closes the added to cart pane
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnCloseIconOnAddedToCartPane() {
		closeLinkOnAddedToCartPane.click();
	}
	
	/**
	 * This function scrolls into technical details section
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void scrollIntTechnicaldetailsSection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", technicalDetailsSection);
	}
	
	
	
}
