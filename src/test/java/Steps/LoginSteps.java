package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("InsideStep - Chrome browser is open");
		
		String projectPath =System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("InsideStep - User is on login page");
		driver.navigate().to("https://www.hudl.com/login");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("InsideStep - User enters username and password");
		driver.findElement(By.id("email")).sendKeys("matthew.redmond.uk@gmail.com");
		driver.findElement(By.id("password")).sendKeys("£££");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("InsideStep - User clicks on login button");
		driver.findElement(By.id("logIn")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("InsideStep - User is navigated to the home page");
		driver.findElement(By.id("ssr-webnav")).isDisplayed();
	}

	@When("user enters vaild username but invalid password")
	public void user_enters_vaild_username_but_invalid_password() {
		System.out.println("InsideStep - User enters vaild username but invalid password");
		driver.findElement(By.id("email")).sendKeys("matthew.redmond.uk@gmail.com");
		driver.findElement(By.id("password")).sendKeys("wrongpassword");
	}

	@When("user enters invaild username but valid password")
	public void user_enters_invaild_username_but_valid_password() {
		System.out.println("InsideStep - User enters invaild username but valid password");
		driver.findElement(By.id("email")).sendKeys("ratthew.medmond@gmail.com");
		driver.findElement(By.id("password")).sendKeys("£££");
	}
	
	@When("user clicks Need Help button")
	public void user_clicks_Need_Help_button() {
		System.out.println("InsideStep - User clicks Need Help button");
		driver.findElement(By.id("forgot-password-link")).click();
	}

	@Then("user is navigated to the login help page")
	public void user_is_navigated_to_the_login_help_page() {
		System.out.println("InsideStep - User is navigated to the login help page");
		driver.findElement(By.id("resetBtn")).isDisplayed();
	}
	
	@And("presses enter key on keyboard")
	public void presses_enter_key_on_keyboard() {
		System.out.println("InsideStep - User presses enter key on keyboard");
		driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
	}
	
	@And("clicks Remember Me checkbox and login button")
	public void clicks_Remember_Me_checkbox_and_login_button() {
		System.out.println("InsideStep - User clicks Remember Me checkbox and login button");
		driver.findElement(By.className("form__label--custom")).click();
		driver.findElement(By.id("logIn")).click();
	}
	
	@And("exits site")
	public void exits_site() {
		System.out.println("InsideStep - User exits site");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}
	
	@When("user returns to site they will be logged in")
	public void user_returns_to_site_they_will_be_logged_in() {
		System.out.println("InsideStep - User returns to site and will be logged in");
		driver.navigate().to("https://www.hudl.com");
		driver.findElement(By.id("ssr-webnav")).isDisplayed();
	}
	
	@Then("error message pops up")
	public void error_message_pops_up() {
		System.out.println("InsideStep - Error message pops up");
		driver.findElement(By.className("login-error-container")).isDisplayed();
	}
}
