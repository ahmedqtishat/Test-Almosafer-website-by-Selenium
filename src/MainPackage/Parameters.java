package MainPackage;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Parameters {
	WebDriver driver = new ChromeDriver();

	static LocalDate currentDate = LocalDate.now();
	// Get just the day of the month
	int day = currentDate.getDayOfMonth();

	void navigateToHomePage() {
		driver.get("https://www.almosafer.com/en");
	}

	void verifyLanguageisEnglish() {
		String actualLanguage = driver.findElement(By.cssSelector("[data-testid='Header__LanguageSwitch']")).getText();
		Assert.assertNotEquals(actualLanguage, "English", "Language is not expected to be English");
	}

	void verifyCurrencyIsSAR() {
		String actualCurrency = driver.findElement(By.cssSelector("[data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(actualCurrency, "SAR", "Currency is expected to be SAR");
	}

	void verifyQitafLogoDisplayed() {
		boolean qitafDisplayed = driver.findElement(By.cssSelector("[data-testid=\"Footer__QitafLogo\"]"))
				.isDisplayed();
		Assert.assertTrue(qitafDisplayed, "Qitaf logo should be displayed in the footer");
	}

	void verifyHotelsTabSelected() {
		boolean hotelsTabSelected = driver.findElement(By.xpath("//a[@id=\"uncontrolled-tab-example-tab-hotels\"]"))
				.isSelected();
		Assert.assertFalse(hotelsTabSelected, "Hotels tab should not  be selected by default");
	}

	void verifyFlightDepartureDateNextDay() {
		String flightDepartureDate = driver
				.findElement(By.cssSelector("[data-testid=\"FlightSearchBox__FromDateButton\"]")).getText();
		int newFlightDateWithNumber = Integer.parseInt(flightDepartureDate.replaceAll("[^0-9]", ""));
		Assert.assertEquals(newFlightDateWithNumber, day + 1, "Flight departure date should be next day");
	}

	void verifyFlightReturnDateNext2Day() {

		String FlightReturnDate = driver.findElement(By.cssSelector("[data-testid=\"FlightSearchBox__ToDateButton\"]"))
				.getText();
		int newFlightReturnDateNumber = Integer.parseInt(FlightReturnDate.replaceAll("[^0-9]", ""));
		Assert.assertEquals(newFlightReturnDateNumber, day + 2, "Flight return should be next two day");
	}

	void navigateToRandomWebsite() {
		driver.get(websites[RandomsWebSiteIndex]);

	}

	void TypeOnAutoCompleteListWithRandomArabicCity() throws InterruptedException {
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();

		driver.findElement(By.cssSelector("[data-testid='AutoCompleteInput']")).sendKeys(Arabic[Randomscities]);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[data-testid=\"AutoCompleteResultItem0\"]")).click();

	}

	void TypeOnAutoCompleteListWithRandomEnglishCity() throws InterruptedException {
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();

		driver.findElement(By.cssSelector("[data-testid='AutoCompleteInput']")).sendKeys(English[Randomscities]);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[data-testid=\"AutoCompleteResultItem0\"]")).click();

	}

	void randomlySelcetRoom() {

	WebElement DropDownEelemnt=driver.findElement(By.cssSelector("[data-testid='HotelSearchBox__ReservationSelect_Select']"));
	Select DropDown = new Select(DropDownEelemnt);
	DropDown.selectByValue(Char[RandomsWebSiteIndex]);
		driver.findElement(By.cssSelector("[data-testid=\"HotelSearchBox__SearchButton\"]")).click();

	}
	
	
	void CheckPageLoaded() throws InterruptedException {
		Thread.sleep(15000); // 
	String reslutsCountTesxt=	 driver.findElement(By.cssSelector("[data-testid=\"HotelSearchResult__resultsFoundCount\"]")).getText();
	
 Boolean CheckText=	reslutsCountTesxt.contains("وجدنا");
 Assert.assertTrue(CheckText, "Check if the page are loaded by Word (وجدنا)");
	}
	
	void CheckPageLoadedEnglish() throws InterruptedException {
		Thread.sleep(15000); // 
	String reslutsCountTesxt=	 driver.findElement(By.cssSelector("[data-testid=\"HotelSearchResult__resultsFoundCount\"]")).getText();
	
 Boolean CheckText=	reslutsCountTesxt.contains("found");
 Assert.assertTrue(CheckText, "Check if the page are loaded by Word (found)");
	}


	static String[] Char = { "A", "B" };
	static String[] websites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	static String[] Arabic = { "الرياض", "جدة", "دبي" };
	static String[] English = { "Riyeadh", "dubai", "Jaddeh" };
	static Random Rand = new Random();

	static int Randomscities = Rand.nextInt(3);
	static int RandomsWebSiteIndex = Rand.nextInt(2);
	SoftAssert Assert = new SoftAssert();

}
