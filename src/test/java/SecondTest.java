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
        page.locator("input#firstName").fill("FirstName");
        page.locator("input#lastName").fill("LastName");
        page.locator("input#email").fill("test@email.com");
        page.locator("input#fld-p1").fill("12345Qwerty@");
        page.locator("input#reenterPassword").fill("12345Qwerty@");

        assertThat(page.locator("span.c-input-error-message"))
                .containsText("Your passwords match!",new LocatorAssertions.ContainsTextOptions()
                        .setTimeout(5_000));

        page.locator("input#phone").fill("7777777777");
        page.locator("input#is-recovery-phone").check();

        assertThat(page.locator("button.cia-form__controls__submit"))
                .isEnabled(new LocatorAssertions.IsEnabledOptions()
                        .setTimeout(5_000));

        System.out.println();


    }

}
