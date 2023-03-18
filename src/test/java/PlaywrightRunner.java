import annotations.PlaywrightPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.AccountNavigationMenu;
import pages.CreateAccountPage;
import services.EnvironmentReaderService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        initPage(this, page);

    }

    @AfterEach
    public void TearDown(){

        browserContext.close();
        browser.close();

    }

    @PlaywrightPage
    protected CreateAccountPage createAccountPage;

    @PlaywrightPage
    protected AccountNavigationMenu accountNavigationMenu;

    // Get pages used in tests
    private void initPage(Object object, Page page) {
        Class<?> pageClass = object.getClass().getSuperclass();
        for(Field field : pageClass.getDeclaredFields()) {
            if(field.isAnnotationPresent(PlaywrightPage.class)) {
                Class<?>[] type = {Page.class};
                try {
                    field.set(this, field.getType().getConstructor(type).newInstance(page));
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    System.out.println("Did not manage to call constructor for playwright page with name " + field.getName());
                }
            }
        }
    }

    // Property reader
    protected String getProperty(String key) {
        return EnvironmentReaderService.getProperty(key);
    }

}
