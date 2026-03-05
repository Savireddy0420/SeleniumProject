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
        System.out.println("Browser maximized.");

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
        System.out.println("Username entered.");
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
        System.out.println("Login button clicked.");

        Thread.sleep(3000);
        System.out.println("Waited 3 seconds for page to load.");

        // Print current URL after login
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentURL);

        Thread.sleep(2000);
        WebElement specificItem = driver.findElement(
        	    By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']/ancestor::div[@class='inventory_item']//button"));
        	specificItem.click();
        	System.out.println("'Test.allTheThings() T-Shirt (Red)' added to cart.");

        	// Verify cart badge shows 1
        	Thread.sleep(1000);
        	String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        	System.out.println("Cart item count = " + cartCount);

        	// Wait 5 seconds
        	Thread.sleep(3000);
        	System.out.println("Waited 3 seconds.");
        	
        	
        	driver.findElement(By.className("shopping_cart_link")).click();
        	System.out.println("Cart icon clicked");
        	Thread.sleep(3000);
        	
        	// Remove from the cart
        	WebElement removeButton = driver.findElement(
        		By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']/ancestor::div[@class='cart_item']//button"));
        	removeButton.click();
        	System.out.println("Item removed from cart.");
        	Thread.sleep(2000);

        	// Verify cart is empty       	
        	List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        	if (cartItems.isEmpty()) {
        	    System.out.println("Cart is now empty! ");
        	} else {
        	    System.out.println("Cart still has items");
        	}
        	
        	// Go Back to Home Page (Continue Shopping)     	
        	driver.findElement(By.id("continue-shopping")).click();
        	System.out.println("Clicked 'Continue Shopping' — back on Home page.");
        	Thread.sleep(2000);
        	
        	// Click Burger Menu ☰
        	driver.findElement(By.id("react-burger-menu-btn")).click();
        	System.out.println("Burger menu opened.");
        	Thread.sleep(2000);
        	
        	//Click Logout
        	driver.findElement(By.id("logout_sidebar_link")).click();
        	System.out.println("Logout clicked.");
        	Thread.sleep(2000);

//        //  Checkbox and Radio Button Handling
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
//        if (checkboxes.isEmpty()) {
//            System.out.println("No checkboxes found on this page.");
//        } else {
//            for (WebElement checkbox : checkboxes) {
//                checkbox.click();
//                System.out.println("✅ Checkbox selected.");
//                Thread.sleep(500);
//                checkbox.click();
//                System.out.println("✅ Checkbox deselected.");
//            }
//        }
//
//        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
//        if (radioButtons.isEmpty()) {
//            System.out.println("No radio buttons found on this page.");
//        } else {
//            radioButtons.get(0).click();
//            System.out.println("✅ First radio button selected.");
//        }
//
//        // Text Box - Enter data
//        List<WebElement> textBoxes = driver.findElements(By.cssSelector("input[type='text']"));
//        if (textBoxes.isEmpty()) {
//            System.out.println("No text box found on this page.");
//        } else {
//            textBoxes.get(0).clear();
//            textBoxes.get(0).sendKeys("Hello Automation!");
//            System.out.println("Text entered: 'Hello Automation!'");
//            Thread.sleep(1000);
//            textBoxes.get(0).clear();
//            System.out.println("Text box cleared.");
//        }

        //Close the browser
        driver.quit();
        System.out.println("Browser closed");

    }
}