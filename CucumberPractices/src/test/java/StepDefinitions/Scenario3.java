package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Scenario3 {
	
	public static WebDriver driver;
	
	@Given("user is navigated to the AUT_TC3")
	public void user_is_navigated_to_the_aut_tc3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");	
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		Thread.sleep(2000);
	}

	@When("user enters following details_TC3")
	public void user_enters_following_details_tc3() {
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div/div/input")).sendKeys("1");
	}

	@When("user clicks on Work out how much I could borrow button_TC3")
	public void user_clicks_on_work_out_how_much_i_could_borrow_button_tc3() throws InterruptedException {
		driver.findElement(By.id("btnBorrowCalculater")).click();
		Thread.sleep(2000);
	}

	@Then("verify the message_TC3")
	public void verify_the_message_tc3() {
		String expectedMsg = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		String actualMsg = driver.findElement(By.xpath("//span[@class = \"borrow__error__text\"]")).getText();
		Assert.assertEquals(expectedMsg, actualMsg);
		driver.close();
	}

	
}
