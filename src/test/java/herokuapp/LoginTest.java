package herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

	@Test
	public void positiveLoginTest() {
		// open page
		loginPage.goToLoginPage();
		// insert valid username
		// insert valid password
		loginPage.insertCredentials("tomsmith", "SuperSecretPassword!");
		// click on Login button
		secureAreaPage = loginPage.clickOnLoginButton();
		// assert Logout button is present
		assertTrue(loginPage.isLogoutButtonPresent(), "Logout button is present!");
	}

	@Test
	public void negativeLoginTest() {
		// open page
		loginPage.goToLoginPage();
		// insert valid username
		// insert invalid password (without special symbol)
		loginPage.insertCredentials("tomsmith", "SuperSecretPassword");
		// click on Login button
		loginPage.clickOnLoginButton();
		// assert Alert massage "Your password is invalid!" is present
		assertTrue(loginPage.isAlertPresent()
				.contains("Your password is invalid!"));
	}
}
