import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowsertest2 {
    /**1. Setup chrome browser.
     2. Open URL.
     3. Print the title of the page.
     4. Print the current url.
     5. Print the page source.
     6. Click on ‘Forgot your password?’ link.
     7. Print the current url.
     8. Navigate back to the login page.
     9. Refresh the page.
     10. Enter the email to email field.
     11. Enter the password to password field.
     12. Click on Login Button.
     13. Close the browser.*/

    static String browser = "Chrome";
    static String baseurl = "https://opensource-demo.orangehrmlive.com"; //I want to open this url
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FF")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {System.out.println("wrong browser name");}

        //Open the url into browser
        driver.get(baseurl);//or use directly the given url

        //To get the title of a website
        String title = driver.getTitle();
        System.out.println(" The title of the page " + title);

        //Get current url eg. login
        String currenturl = driver.getCurrentUrl();
        System.out.println("The current url : " + currenturl);

        //Get page source
        System.out.println("The source :" + driver.getPageSource());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Forgot your password
        driver.findElement(By.className("orangehrm-login-forgot")).click();

        //print the current url back
        System.out.println("Get current url :" + driver.getCurrentUrl());

        //Store the login url in a loginUrl string-Navigate
        String loginUrl = "https://opensource-demo.orangehrmlive.com/";
        driver.navigate().to(loginUrl);

        //Refresh the page
        driver.navigate().refresh();

        //Enter the email to email field
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter the password in a password field
        driver.findElement(By.name("password")).sendKeys("admin123");


        // Assuming the login button has the name 'login'
        driver.findElement(By.tagName("button")).click();


        //Close the browser
        driver.quit();
    }
}

