package test;

import org.testng.annotations.Test;

import utils.Action;

public class NavigationTests extends BaseTest {

	Action ac;

	@Test(description = "Navigation to wishlist test")
	public void wishlistNavigationTest() {
		ac = Action.getActionClass();
		ac.navigateToAccountsAndLists(BaseTest.getDriver());
		ac.verifyBannerText(BaseTest.getDriver());

	}
	
	@Test(description = "Navigation to AmazonPay test")
	public void NavigationToAmazonPayTest() {
		ac = Action.getActionClass();
		ac.navigateToAmazonPay(BaseTest.getDriver());
		ac.verifyAmazonPayLandingPage(BaseTest.getDriver());

	}
	
	@Test(description = "Navigation to New Releases test")
	public void NavigationToNewReleasesTest() {
		ac = Action.getActionClass();
		ac.navigateToNewReleases(BaseTest.getDriver());
		ac.verifyNewReleasesLandingPage(BaseTest.getDriver());

	}

}
