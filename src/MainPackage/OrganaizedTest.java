package MainPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrganaizedTest extends Parameters {
	@BeforeTest
	public void setUp() {
	}

	@Test(enabled = false)
	public void testMainFunctionality() {
		navigateToHomePage();

		driver.findElement(By.className("cta__saudi")).click();

		verifyLanguageisEnglish();
		verifyCurrencyIsSAR();
		verifyQitafLogoDisplayed();
		verifyHotelsTabSelected();
		verifyFlightDepartureDateNextDay();
		verifyFlightReturnDateNext2Day();
	}
	
	@Test () 
	public void test_website_with_random_Languges() throws InterruptedException {
	  //  driver.manage().window().maximize();

		 navigateToRandomWebsite();

			driver.findElement(By.className("cta__saudi")).click();

		if (driver.getCurrentUrl().contains("ar")) {
			TypeOnAutoCompleteListWithRandomArabicCity();
			randomlySelcetRoom();
			 CheckPageLoaded() ;
		}
		else {
			TypeOnAutoCompleteListWithRandomEnglishCity();
			randomlySelcetRoom();
			CheckPageLoadedEnglish();
		}
		
	}

	@AfterTest
	public void AfterTest() {
		Assert.assertAll(); // Ensures all assertions are executed
	}

}
