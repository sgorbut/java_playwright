import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTest extends PlaywrightRunner {

    @Test
    public void dealOfTheDayTimerTest() {

        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        Locator dealOfTheDay = page.locator("a:has-text('Deal of the Day')"); // text locator
        dealOfTheDay.click();

        assertThat(page.locator(".countdown-clock")).isVisible(); // css locator

    }

}
