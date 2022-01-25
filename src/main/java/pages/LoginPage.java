package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private static final String LOGIN_URL = BASE_URL + "/login";

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(css = ".radius")
	WebElement loginButton;

	public void goToLoginPage() {
		driver.navigate().to(LOGIN_URL);
	}

	public void insertCredentials(String usernameValue, String passwordValue) {
		username.click();
		username.clear();
		username.sendKeys(usernameValue);
		password.click();
		password.clear();
		password.sendKeys(passwordValue);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	@FindBy(xpath = "//i[contains(.,'Logout')]")
	WebElement logoutButton;

	public boolean isLogoutButtonPresent() {
		return logoutButton.isDisplayed();
	}

	@FindBy(id = "flash")
	WebElement alertText;

	public String isAlertPresent() {
		return alertText.getText();
	}
}
