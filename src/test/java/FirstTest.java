import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTest {

    @Test
    public void dealOfTheDayTimerTest() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        Page page = browserContext.newPage();

        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        Locator dealOfTheDay = page.locator("a:has-text('Deal of the Day')"); // text locator
        dealOfTheDay.click();

        assertThat(page.locator(".countdown-clock")).isVisible(); // css locator

    }

}
