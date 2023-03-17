import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimpleTest {

    @Test
    public void firstTest() throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        Page page = browserContext.newPage();

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
//        page.locator("//a[@data-lid='hdr_dotd']").click();    //xpath
//        page.locator("a:has-text('Deal of the Day')").click();  //text

        Locator dealOfTheDay = page.locator("a:has-text('Deal of the Day')");
        dealOfTheDay.click();

        Thread.sleep(5000);

    }

}
