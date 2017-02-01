package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.Set;

import static maps.LoginPage.*;
import static maps.LoginPage.EMAIL;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 31.01.2017.
 */
public class Login extends TestBase {

    private final WebDriver driver;

    public Login(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public Login(final WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(final String email) {
        typeText(driver, EMAIL.by(), email);
    }

    public void typePassword(final String password) {
        typeText(driver, PASSWORD.by(), password);
    }

    public void clickSubmenu(){
       click(driver,SUBMENU_BUTTON.by());
   }

    public void clickSIgnUp(){
       click(driver,SIGNUP.by());
   }

    public void clickLogin(){
       click(driver,LOGIN_BUTTON.by());
   }

   public void clickLincRessetYourPassword(){
        click(driver,LINK_RESET_YOUR_PASSWORD.by());
   }

    public void clickRecoverButton(){
        click(driver,RECOVER_BUTTON.by());
    }

    public void clickCancelButton(){
        click(driver,CANCEL_BUTTON.by());
    }

    public void clickResetPassword(){
       click(driver,RESET_PASSWORD.by());
   }

    public void clickGoToComunity(){
       click(driver,GO_TO_COMUNITY.by());
   }

    public void clickUserButton(){
        click(driver,USER_BUTTON.by());
    }

    public void clickSignOutButton(){
        click(driver,SIGN_OUT_BUTTON.by());
    }

   public String getLinkTermsOfService(){
       WebElement service = driver.findElement(By.xpath(".//*[@id='ext-comp-1030']/a[1]"));
       String termsOfService = service.getAttribute("href");
       return termsOfService;
   }

    public String getLinkPrivacyPolicy(){
        WebElement service = driver.findElement(By.xpath(".//*[@id='ext-comp-1030']/a[2]"));
        String privacyPolicy = service.getAttribute("href");
        return privacyPolicy;
    }

    public String getSuccessMessage() {
        if (waitElementPresent(driver, MESSAGE.by(), wait)) {
            return getText(driver, MESSAGE.by());
        } else {
            return "";
        }
    }

    public String getMessage(By locator) {
        if (waitElementPresent(driver, locator, wait)) {
            return getText(driver, locator);
        } else {
            return "";
        }
    }

    public String getWeHaneJustMessage() {
        if (waitElementPresent(driver, MESSAGE_WE_HAVE_JUST.by(), wait)) {
            return getText(driver, MESSAGE_WE_HAVE_JUST.by());
        } else {
            return "";
        }
    }

    public String getGoToMailboxMessage() {
        if (waitElementPresent(driver, MESSAGE_GO_TO_MAILBOX.by(), wait)) {
            return getText(driver, MESSAGE_GO_TO_MAILBOX.by());
        } else {
            return "";
        }
    }

    public String getIncorrectEmailMessage() {
        if (waitElementPresent(driver, MESSAGE_INCORRECT_EMAIL.by(), wait)) {
            return getText(driver, MESSAGE_INCORRECT_EMAIL.by());
        } else {
            return "";
        }
    }

    public boolean elementEnabled(WebElement s){
        if (!s.isEnabled()) {
            return false;
        }
            return  true;
        }


    public ExpectedCondition<String> anyWindowOtherThen (Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    public void OpenWindow (String window){
        driver.switchTo().window(window);
    }

    public void CloseWindow (){
        driver.close();
    }


}


