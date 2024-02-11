package MainPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMosaferWebSite extends Parameters {
	@BeforeTest
	public void setUp() {
		   driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void testMainFunctionality() {
		navigateToHomePage();

		driver.findElement(By.className("cta__saudi")).click();

		verifyLanguageisNotEnglish();
		verifyCurrencyIsSAR();
		verifyQitafLogoDisplayed();
		verifyHotelsTabSelected();
		verifyFlightDepartureDateNextDay();
		verifyFlightReturnDateNext2Day();
	}
	
	@Test () 
	public void test_website_with_random_Languges() throws InterruptedException {

		 navigateToRandomWebsite();

			driver.findElement(By.className("cta__saudi")).click();

		if (driver.getCurrentUrl().contains("ar")) {
			TypeOnAutoCompleteListWithRandomArabicCity();
			randomlySelcetRoom();
			 CheckPageLoaded() ;
			 lowesPriceAssersion();
		}
		else {
			TypeOnAutoCompleteListWithRandomEnglishCity();
			randomlySelcetRoom();
			CheckPageLoadedEnglish();
			lowesPriceAssersion();
			
		}
		
	}

	@AfterTest
	public void AfterTest() {
		Assert.assertAll(); // Ensures all assertions are executed
	}

}
