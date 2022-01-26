package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
	public LoginPage(WebDriver driver) {
		super(driver);
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

	public SecureAreaPage clickOnLoginButton() {
		loginButton.click();
		return new SecureAreaPage(driver);
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
