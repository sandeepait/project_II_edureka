package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.Action;

public class LoginTest extends BaseTest {

	Action ac;
	
	@Test(description="Invalid email test")
	@Parameters({"emailInput"})
	public void invalidEmailTest(String emailInput){
		ac = Action.getActionClass();
		ac.clickonSignIn(BaseTest.getDriver());
		ac.verifySignInPage(BaseTest.getDriver());
		ac.inputEmailIntoInputBox(BaseTest.getDriver(), emailInput);
		ac.clickOnContinueButton(BaseTest.getDriver());
		ac.verifyInvalidEmailErrorMessage(BaseTest.getDriver());
	}
}
