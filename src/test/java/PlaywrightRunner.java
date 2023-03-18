import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class PlaywrightRunner {

    protected Page page;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected static Playwright playwright;

    @BeforeAll
    public static void Init(){

        playwright = Playwright.create();

    }

    @BeforeEach
    public void Setup(){

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser
                .newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        page = browserContext.newPage();

    }

    @AfterEach
    public void TearDown(){

        browserContext.close();
        browser.close();

    }

}