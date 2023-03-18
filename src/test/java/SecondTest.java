import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SecondTest extends PlaywrightRunner {

    @Test
    public void fillRegistrationFormTest() {

        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        page.locator("button[data-lid='hdr_signin']").click();
        page.locator("div.header-guest-user a.create-account-btn").click();

        createAccountPage.createAccount();

    }

}
