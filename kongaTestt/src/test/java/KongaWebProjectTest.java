import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebProjectTest {
    //import selenium WebDriver
    private WebDriver driver;

@BeforeTest
public void start() throws InterruptedException {
        //Locate where the Chromebrowser is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        //1.Open the Chrome Browser
        driver = new ChromeDriver();
        //2.Maximize the browser
        driver.manage().window().maximize();
        //3.Visit the URL Konga (https://www.konga.com/)
        driver.get("https://www.konga.com");
        // Test1.Verify that user input the right URL and it's on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("Current Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
}

@Test(priority = 0 )
public void Loginpage() throws InterruptedException {
        //4.Click on login button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Test2.Verify that when user click on the login button,the user is directed to the login page
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong WebPage");
        Thread.sleep(5000);
}

@Test(priority = 1 )
public void successfulLogin() throws InterruptedException {
    //5. Input your username /email on the username field
    driver.findElement(By.id("username")).sendKeys("itunufatoki14@gmail.com");
    //6. Input Your password in the password field
    driver.findElement(By.id("password")).sendKeys("@itunu1234");
    Thread.sleep(3000);
    //7. Click on LogIN button
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
    //Test3. Verify that user successfully login with valid details and receive a success message
    String expectedUrl = "https://www.konga.com/";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl))
        //pass
        System.out.println("Correct WebPage");
    else
        //fail
        System.out.println("Wrong WebPage");
    Thread.sleep(5000);
}

@Test(priority = 2 )
public void Categories() throws InterruptedException {
         //Test4. Verify that Apple Macbook under laptop sub category is present
        //3. From the Categories, Select the "Computers and Accessories"
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        //Create an instance of Actions class
        Actions actions = new Actions(driver);
        //Hover over the element
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(5000);
}

@Test (priority = 3)
public void selectMacBook() throws InterruptedException {
        //Select MacBook
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(5000);
        String expectedPageUrl = "https://www.konga.com/category/macbooks-5249";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(7000);
}

@Test(priority = 4 )
public void itemtocart() throws InterruptedException {
        //11. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //Click on my cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);
        //Test5. verify that item1 is successfully added to cart with the right quantity reflected
        String expectedPageUrl = "https://www.konga.com/category/macbooks-5249";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
}

@Test(priority = 5)
public void checkout() throws InterruptedException {
        //13. Click on checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        //Test6. verify that the checkout process run smoothly
        String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
}
@Test(priority = 6)
public void deliveryaddress() throws InterruptedException {
        //.  Click on change address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        //.  Click on Add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        //.  Add first address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(5000);
        //.  Click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        //Test7. Verify that the system validates the address and the  checkout process continues smoothly
        String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(7000);
}

@Test (priority = 7 )
public void payment() throws InterruptedException {
        //. Go to the payment options, click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        // Click on the continue payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        //Test8. Verify that the page to select payment method was displayed.
        String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
}

@Test (priority = 8)
public void iframe() throws InterruptedException {
        //20 select a card payment method
        //20a change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        //Test9. Verify that card payment method was successfully changed from default to iframe
        String expectedTitle = "SELECT PAYMENT METHOD";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(7000);
}

    @Test(priority = 9 )
    public void cardpayment() throws InterruptedException {
        // select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("select card method");
        Thread.sleep(5000);
}

@Test (priority = 10)
public void inputcarddetails () throws InterruptedException {
        //. input individual card details
        // input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("123456754321");
        Thread.sleep(3000);
        // input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1125");
        Thread.sleep(3000);
        // input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("256");
        Thread.sleep(5000);
        System.out.println("input card details");
}

@Test (priority = 11)
public void errormessage () throws InterruptedException {
        // print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
}

@Test (priority = 12)
public void closeframe () throws InterruptedException {
        //12 close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("exit iframe");
        Thread.sleep(5000);
}

@AfterTest
public void closeBrowser() throws InterruptedException {
        //37. Quit the browser.
        driver.quit();
        Thread.sleep(5000);
}

}


