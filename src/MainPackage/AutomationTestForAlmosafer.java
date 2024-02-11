package MainPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTestForAlmosafer extends Parameters {

	@BeforeTest
	public void BeforeTest() {
	}

	@Test()
	public void MainTest() {

		driver.get("https://www.almosafer.com/en");

		driver.findElement(By.className("cta__saudi")).click();

		String ActualLanguageofWebsite = driver.findElement(By.cssSelector("[data-testid='Header__LanguageSwitch']"))
				.getText();

		Assert.assertNotEquals(ActualLanguageofWebsite, "English", "Language is not expected to be English");
// Assertion to check the current language is English.

		String Actualcurrency = driver.findElement(By.cssSelector("[data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(Actualcurrency, "SAR");// Assertion to check The Currency is SAR.

		Boolean Qitaf = driver.findElement(By.cssSelector("[data-testid=\"Footer__QitafLogo\"]")).isDisplayed();

		Boolean Tab = driver.findElement(By.xpath("//a[@id=\"uncontrolled-tab-example-tab-hotels\"]")).isSelected();

		Assert.assertEquals(Qitaf, true);

		String Flight_Departure_date = driver
				.findElement(By.cssSelector("[data-testid=\"FlightSearchBox__FromDateButton\"]")).getText();

		int NewFlightDateWithNumber = Integer.parseInt(Flight_Departure_date.replaceAll("[^0-9]", ""));
		
System.out.println(NewFlightDateWithNumber);
		Assert.assertEquals(NewFlightDateWithNumber, day + 1);

	}

	@AfterTest
	public void AfterTest() {
		Assert.assertAll();
	}

}
