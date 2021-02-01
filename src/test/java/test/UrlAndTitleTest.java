package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Action;

public class UrlAndTitleTest extends BaseTest{
	
	@Test(description="URL and title test")
	public void urlAndTitleTest() {
		
		Assert.assertEquals(Action.getActionClass().getCurrentURL(BaseTest.getDriver()), Action.getActionClass().readFromLangTextProperties("expectedURL"));
		Assert.assertEquals(Action.getActionClass().getPageTitle(BaseTest.getDriver()), Action.getActionClass().readFromLangTextProperties("homePageTitle"));
	}

}
