package sitepages;

import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NavigationPage {
	
	private WebDriver driver;
	
	public NavigationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="(//a[@data-nav-role='signin'])[1]")
	WebElement linkSignIn;
	
	
	@CacheLookup
	@FindBy(xpath="//div[@id='nav-al-wishlist']/a[1]")
	WebElement linkCreateYourWishList;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='wishlist-page']//div[@class='a-section al-intro-banner a-spacing-none']")
	WebElement wishListPageBanner;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(@data-csa-c-content-id, 'nav_cs_apay')]")
	WebElement amazonPayNav;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='APayBalance']/div/div/div/span")
	WebElement amazonPayBalance;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(@data-csa-c-content-id, 'nav_cs_newreleases')]")
	WebElement amazonNavNewReleases;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(@data-csa-c-content-id, 'nav_cs_mobiles')]")
	WebElement mobilesNavLink;
	
	
	@CacheLookup
	@FindBy(xpath="//div[@id='zg_banner_text_wrapper']")
	WebElement amazonNewReleasesBanner;
	
	@CacheLookup
	@FindBy(xpath="(//a[@data-nav-role='signin'])[1]")
	WebElement signInLink;
	
	@CacheLookup
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement searchDropdown;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchBoxButton;
	
	/**
	 * This function perfoms the action of hovering over the signin link
	 * @param none
	 * @author sandeep
	 * 
	 */
	public void hoverOverSingnInLink() {
		Actions ac = new Actions(driver);
		ac.moveToElement(linkSignIn).build().perform();
	}
	
	/**
	 * This function clicks on the create your wishlist link
	 * @param none
	 * @author sandeep
	 * 
	 */
	public void clickOnCreateYourWishList() {
		linkCreateYourWishList.click();
	}
	
	/**
	 * This function gets the text from page banner
	 * @param none
	 * @author sandeep
	 * @return String
	 * 
	 */
	public String getTextFromPageBanner() {
		return wishListPageBanner.getText();
	}
	
	/**
	 * This function click on Amazon pay on the navigation
	 * @param none
	 * @author sandeep
	 * @return none
	 * 
	 */
	public void clickOnAmazonPay() {
		 amazonPayNav.click();
	}
	
	/**
	 * This function click on Amazon pay on the navigation
	 * @param none
	 * @author sandeep
	 * @return String
	 * 
	 */
	public String getAmazonPayBalance() {
		return amazonPayBalance.getText();
	}
	
	/**
	 * This function clicks on New Releases on the navigation
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnNewReleases() {
		amazonNavNewReleases.click();
	}
	
	/**
	 * This function returns banner text for New Releases
	 * @param none
	 * @author sandeep
	 * @return String
	 * 
	 */
	public String getBannerTextForNewReleases() {
		return amazonNewReleasesBanner.getText();
	}
	
	/**
	 * This function clicks on Sign In Link
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnSignInLink() {
		signInLink.click();
	}
	
	/**
	 * This function selects category in the searchdropdown
	 * @param String category
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void selectCategoryOnDropdown(String category) {
		Select se= new Select(searchDropdown);
		se.getOptions().forEach(new Consumer<WebElement>() {
			public void accept(WebElement s) {
				System.out.println(s.getText());
				
			}
		});
		se.selectByValue(category);
	}
	
	/**
	 * This function enters the input into the searchbox
	 * @param String searchText
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void enterTextOnSearchBox(String searchText) {
		searchBox.sendKeys(searchText);
	}
	
	/**
	 * This function clicks on the search button on the searchbox
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnSearchButton() {
		searchBoxButton.click();
	}
	
	/**
	 * This function clicks on moblile in the navigation
	 * @param none
	 * @author sandeep
	 * @return nothing
	 * 
	 */
	public void clickOnMiblesNavLink() {
		mobilesNavLink.click();
	}
	
	
	

}
