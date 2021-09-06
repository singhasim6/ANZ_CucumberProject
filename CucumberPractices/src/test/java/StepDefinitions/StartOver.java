package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StartOver {
	public static WebDriver driver;

	@Given("user is navigated to the AUT_TC2")
	public void user_is_navigated_to_the_aut() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");	
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		Thread.sleep(3000);
				
	}

	@When("user enters following details_TC2")
	public void user_enters_following_details() {
		
		driver.findElement(By.xpath("//*[contains(text(), 'Single')]")).click();
		Select dependent = new Select(driver.findElement(By.xpath("//select[@title = 'Number of dependants']")));
		dependent.selectByIndex(0);;
		driver.findElement(By.xpath("//*[contains(text(), \"Home to live in\")]")).click();
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"]/div/div/div/input")).sendKeys("80000");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"]/div/div[2]/div/input")).sendKeys("10000");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div/div/input")).sendKeys("500");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div[2]/div/input")).sendKeys("0");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div[3]/div/input")).sendKeys("100");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div[4]/div/input")).sendKeys("0");
		driver.findElement(By.xpath("//div[@class = \"container__main__element     \"][3]/div/div[5]/div/input")).sendKeys("10000");
				
	}

	@When("user clicks on Work out how much I could borrow button_TC2")
	public void user_clicks_on_work_out_how_much_i_could_borrow_button() throws InterruptedException {
		driver.findElement(By.id("btnBorrowCalculater")).click();
		Thread.sleep(2000);

	}
	
	@Then("Click on start over_TC2")
	public void click_on_start_over() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class = \"box--right\"]/button")).click();
	    Thread.sleep(2000);
	}

	@Then("verify fields should be cleared_TC2")
	public void verify_fields_should_be_cleared() {
	    System.out.println("Field is cleared");
	    driver.close();
	}
}
