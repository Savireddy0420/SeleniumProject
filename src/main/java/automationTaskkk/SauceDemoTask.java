package automationTaskkk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class SauceDemoTask {

    public static void main(String[] args) throws Exception {

        // Launch Chrome Browser
    	// Launch Chrome Browser
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
    	options.addArguments("--disable-save-password-bubble");
    	options.addArguments("--disable-notifications");
    	options.addArguments("--no-first-run");
    	options.addArguments("--disable-extensions");
    	WebDriver driver = new ChromeDriver(options);
        System.out.println("Chrome browser launched.");

        // Maximize the browser window
        driver.manage().window().maximize();
        System.out.println(" Browser maximized.");

        // Navigate to SauceDemo website
        driver.get("https://www.saucedemo.com/");
        System.out.println("Navigated to https://www.saucedemo.com/");

        // Verify page title BEFORE login
        String titleBeforeLogin = driver.getTitle();
        System.out.println("Page title before login = " + titleBeforeLogin);

        // Enter Username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("standard_user");
        System.out.println(" Username entered.");
        Thread.sleep(2000);

        // Enter Password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        System.out.println(" Password entered.");
        Thread.sleep(2000); 
        
        // Click Login Button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println(" Login button clicked.");

        // Wait for page to load
        Thread.sleep(3000);
        System.out.println(" Waited 3 seconds for page to load.");

        // Print page title AFTER login
        String titleAfterLogin = driver.getTitle();
        System.out.println(" Page title after login = " + titleAfterLogin);

        // Print current URL after login
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentURL);

        //Handle Alert
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert found! Text = " + alert.getText());
            alert.accept();
            System.out.println("Alert closed.");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present. (That's fine!)");
        }

        //  Checkbox and Radio Button Handling
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        if (checkboxes.isEmpty()) {
            System.out.println("No checkboxes found on this page.");
        } else {
            for (WebElement checkbox : checkboxes) {
                checkbox.click();
                System.out.println("   ✅ Checkbox selected.");
                Thread.sleep(500);
                checkbox.click();
                System.out.println("   ✅ Checkbox deselected.");
            }
        }

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        if (radioButtons.isEmpty()) {
            System.out.println(" No radio buttons found on this page.");
        } else {
            radioButtons.get(0).click();
            System.out.println("   ✅ First radio button selected.");
        }

        // Text Box - Enter data
        List<WebElement> textBoxes = driver.findElements(By.cssSelector("input[type='text']"));
        if (textBoxes.isEmpty()) {
            System.out.println(" No text box found on this page.");
        } else {
            textBoxes.get(0).clear();
            textBoxes.get(0).sendKeys("Hello Automation!");
            System.out.println(" Text entered: 'Hello Automation!'");
            Thread.sleep(1000);
            textBoxes.get(0).clear();
            System.out.println(" Text box cleared.");
        }

        //Close the browser
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Browser closed properly.");

        System.out.println("\n🎉 ALL STEPS COMPLETED SUCCESSFULLY!");
    }
}