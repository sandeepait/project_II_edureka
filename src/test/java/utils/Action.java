package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import sitepages.LoginPage;
import sitepages.NavigationPage;
import sitepages.SearchResultsPage;
import test.BaseTest;

/**
 * This Class provides the commonly used keywords and functions
 * 
 * @author sandeep
 * 
 */
public class Action {
	private static Action Instance;
	private static String firstWindow="";
	private static String secondWindow="";
	private static String thirdWindow="";
	
	
	//private constructor
	private Action() {
		
	}
	
	/**
	 * This method gives object through singleton pattern lazy initialization
	 * @return Action Instance
	 */
	public static Action getActionClass() {
		if(Instance==null) {
			Instance=new Action();
		}
		return Instance;
	}
	
	
	/**
	 * This function reads the data from Config.Properties file for the specific key provided and returns the corresponding value
	 * 
	 * @param key
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public String readFromConfigProperties(String key) {
		
		FileInputStream fis;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Config.properties");
			prop.load(fis);
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return null;

	}
	
	/**
	 * This function returns the title of the current page
	 * 
	 * @param WebDriver
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	/**
	 * This function returns the Current URL
	 * 
	 * @param WebDriver
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * This function reads the data from langText.Properties file for the specific key provided and returns the corresponding value
	 * 
	 * @param key
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public String readFromLangTextProperties(String key) {
		
		String langTexFile = readFromConfigProperties("language").equalsIgnoreCase("english")?"englishText.properties":"Other";
		
		FileInputStream fis;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+langTexFile);
			prop.load(fis);
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return null;

	}
	
	/**
	 * This function returns the Current URL
	 * 
	 * @param WebDriver
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public void navigateToAccountsAndLists(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.hoverOverSingnInLink();
		np.clickOnCreateYourWishList();
	}
	
	/**
	 * This function returns the Current URL
	 * 
	 * @param WebDriver
	 * @return String value
	 * @author sandeep
	 * 
	 */
	public void verifyBannerText(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		Assert.assertEquals(np.getTextFromPageBanner(), readFromLangTextProperties("wishListBannerText"));
		
	}
	
	/**
	 * This function clicks on Amazon Pay on the navigation
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void navigateToAmazonPay(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnAmazonPay();
		
	}
	
	/**
	 * This function verifies Amazon Pay landing page
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyAmazonPayLandingPage(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		Assert.assertEquals(np.getAmazonPayBalance(), readFromLangTextProperties("amazonPayBalanceText"));
		
	}
	
	/**
	 * This function clicks on New Releases on the navigation
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void navigateToNewReleases(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnNewReleases();;
		
	}
	
	/**
	 * This function verifies New Releases landing page
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyNewReleasesLandingPage(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		Assert.assertEquals(np.getBannerTextForNewReleases(), readFromLangTextProperties("newReleasesBannerText"));
		
	}
	
	/**
	 * This function clicks on Sign in Link
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickonSignIn(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnSignInLink();
	}
	
	/**
	 * This function verifies signInPage
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifySignInPage(WebDriver driver) {
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.getHeadingOnPage(), readFromLangTextProperties("signInHeading"));
		
	}
	
	/**
	 * This function inputs email into the email field
	 * 
	 * @param WebDriver
	 * @param String inputEmail
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void inputEmailIntoInputBox(WebDriver driver, String email) {
		LoginPage lp = new LoginPage(driver);
		lp.inputTextOnEmailBox(email);
		
	}
	
	/**
	 * This function clicks on continue button
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnContinueButton(WebDriver driver) {
		LoginPage lp = new LoginPage(driver);
		lp.clickOnContinueButton();
		
	}
	
	/**
	 * This function verify error message for invalid email id
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyInvalidEmailErrorMessage(WebDriver driver) {
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.getErrorMessage(), readFromLangTextProperties("inValidEmailErrorMessage"));
	}
	
	/**
	 * This function selects value on the dropdown
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void selectCategoryOnDropdown(WebDriver driver, String category) {
		NavigationPage np = new NavigationPage(driver);
		np.selectCategoryOnDropdown(category);
	}
	
	/**
	 * This function enters the text in the search text box
	 * 
	 * @param WebDriver
	 * @param String searchText
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void enterTextIntheSearchBox(WebDriver driver, String searchText) {
		NavigationPage np = new NavigationPage(driver);
		np.enterTextOnSearchBox(searchText);
	}
	
	/**
	 * This function click on the mobile link on the navigation
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnMobilesLinkOnTheNavigation(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnMiblesNavLink();
	}
	
	/**
	 * This function click on search button on the searchbox
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnTheSearchButton(WebDriver driver) {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnSearchButton();
	}
	
	/**
	 * This function verifies top search bar text
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyTopSearchBarText(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		Assert.assertEquals(srp.getSearchResultTopBarText(),  readFromLangTextProperties("searchTopBarText"));
	}
	
	/**
	 * This function selects 4 start review 
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void selectFourStarReview(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.selectFourStarReview();
	}
	
	/**
	 * This function selects first result from search
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void selectFirstProdct(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.selectFirstProduct();
	}
	
	/**
	 * This switch to product page
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void switchToProductPage(WebDriver driver) {
		firstWindow = driver.getWindowHandle();
		Set<String> openWindows = driver.getWindowHandles();
		
		for(String s:openWindows) {
			if(!s.equalsIgnoreCase(firstWindow)) {
				driver.switchTo().window(s);
				secondWindow=s;
			}
		}
	}
	
	/**
	 * This switch to product page
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyRedmitTitleforProductPage(WebDriver driver) {
		Assert.assertEquals(BaseTest.getDriver().getTitle(), readFromLangTextProperties("redmiTitleForPage"));
	}
	
	/**
	 * This function verifies the product price
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyProductPrice(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		Assert.assertEquals(srp.getProductPrice().substring(2), readFromLangTextProperties("productPrice"));
	}
	
	/**
	 * This function clicks on select my delivery location link
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnSelectMyDeliveryLocation(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickOnDeliveryLocation();
	}
	
	/**
	 * This function enters pin code into the box
	 * 
	 * @param WebDriver
	 * @param String pinCode
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void enterPinCodeIntoThePinCodeBox(WebDriver driver, String pinCode) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.enterPinCodeIntoBox(pinCode);
	}
	
	/**
	 * This function clicks on apply on the pincode box
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnApplyButtonOnPinCodeBox(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickApplyOnPinCodeBox();
	}
	/**
	 * This function verifies deliver to location text
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyDeliverToLocationText(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		Assert.assertEquals(srp.getDeliverToLocationText().substring(0,srp.getDeliverToLocationText().length()-1), readFromLangTextProperties("deliverToLocationText"));
	}
	
	/**
	 * This function verifies deliver to location text
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnCompareProductWithSponsoredProduct(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickOnCompareProductwithSponsoredProduct();
	}
	
	/**
	 * This function switch to third(compare) window and close it
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void switchToCompareWindowAndClose(WebDriver driver) {
		Set<String> openWindows = driver.getWindowHandles();
		System.out.println("firstWindow "+firstWindow);
		System.out.println("secondWindow "+secondWindow);
		openWindows.stream().forEach(System.out::print);
		
		for(String s:openWindows) {
			if((!((s.equalsIgnoreCase(firstWindow))&&(s.equalsIgnoreCase(secondWindow))))) {
				driver.switchTo().window(s);
				driver.close();
				System.out.println("switched To:-"+s);
				break;
			}
		}
		driver.switchTo().window(secondWindow);
	}
	
	/**
	 * This function clicks on add to cart button
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnAddToCartButton(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickOnAddToCartLink();
	}

	/**
	 * This function verifies added to cart message
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void verifyAddedToCartMessage(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		Assert.assertEquals(srp.getAddedToCartText(), readFromLangTextProperties("addedToCartText"));
	}
	
	/**
	 * This function clicks on close icon on the added to cart pane
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void clickOnCloseIconOnAddedToCartPane(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickOnCloseIconOnAddedToCartPane();
	}
	
	/**
	 * This function scrolls Into View the technical details section
	 * 
	 * @param WebDriver
	 * @return nothing
	 * @author sandeep
	 * 
	 */
	public void scrollIntoViewTechnicalDetailsSection(WebDriver driver) {
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.scrollIntTechnicaldetailsSection();
	}
}
