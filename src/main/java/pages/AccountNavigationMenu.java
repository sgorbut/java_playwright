package pages;

import com.microsoft.playwright.Page;

public class AccountNavigationMenu {

    private final Page accountNavigationMenu;

    private static final String ACCOUNT_BUTTON = "button[data-lid='hdr_signin']";
    private static final String ACCOUNT_LINKS_TEMPLATE = "//div[@class='account-menu']//a[text() = '%s']";

    public AccountNavigationMenu(Page page) {
        this.accountNavigationMenu = page;
    }

    public void navigateTo(AccountEntries accountEntries) {
        accountNavigationMenu.locator(ACCOUNT_BUTTON).click();
        accountNavigationMenu.locator(String.format(ACCOUNT_LINKS_TEMPLATE, accountEntries.getDisplayName())).click();
    }

}
