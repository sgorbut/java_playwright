import org.junit.jupiter.api.Test;
import pages.AccountEntries;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SecondTest extends PlaywrightRunner {

    @Test
    public void fillRegistrationFormTest() {

        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        accountNavigationMenu.navigateTo(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.fillAccountRegistrationForm();

    }

}
