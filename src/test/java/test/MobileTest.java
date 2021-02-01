package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Action;

public class MobileTest extends BaseTest{
	Action ac;
	
	@Test(description="Mobile Test")
	public void mobileTest() throws InterruptedException {
		ac = Action.getActionClass();
		ac.clickOnMobilesLinkOnTheNavigation(BaseTest.getDriver());
		ac.enterTextIntheSearchBox(BaseTest.getDriver(), "Redmin 9");
		ac.clickOnTheSearchButton(BaseTest.getDriver());
		ac.selectFirstProdct(BaseTest.getDriver());
		ac.switchToProductPage(BaseTest.getDriver());
		ac.verifyRedmitTitleforProductPage(BaseTest.getDriver());
		ac.verifyProductPrice(BaseTest.getDriver());
		ac.clickOnSelectMyDeliveryLocation(BaseTest.getDriver());
		ac.enterPinCodeIntoThePinCodeBox(BaseTest.getDriver(), "121006");
		ac.clickOnApplyButtonOnPinCodeBox(BaseTest.getDriver());
		Thread.sleep(5000);
		ac.verifyDeliverToLocationText(BaseTest.getDriver());
		ac.clickOnCompareProductWithSponsoredProduct(BaseTest.getDriver());
		Thread.sleep(5000);
		ac.switchToCompareWindowAndClose(BaseTest.getDriver());
		ac.clickOnAddToCartButton(BaseTest.getDriver());
		ac.verifyAddedToCartMessage(BaseTest.getDriver());
		ac.clickOnCloseIconOnAddedToCartPane(BaseTest.getDriver());
		ac.scrollIntoViewTechnicalDetailsSection(BaseTest.getDriver());
		Thread.sleep(10000);
	
	}
}
