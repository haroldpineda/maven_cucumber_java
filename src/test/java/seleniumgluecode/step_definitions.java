package seleniumgluecode;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class step_definitions {
    public static WebDriver driver;
    
    // general use for all scenarios
    
    @Given("^I use Mozilla Firefox and I want to enter the page sahi link \"([^\"]*)\"$")
    public void user_is_on_homepage_firefox(String arg0) {     
    	System.setProperty("webdriver.gecko.driver","/Users/haroldpinedavaliente/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg0);
    }
    
    @Given("^I use Google Chrome and I want to enter the page sahi link \"([^\"]*)\"$")
    public void user_is_on_homepage_chrome(String arg0) {     
    	System.setProperty("webdriver.chrome.driver","/Users/haroldpinedavaliente/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg0);
    }
    
    @When("^I close browser$")
    public void user_close_browser() throws Throwable {
        driver.close();
    }
    
    // use for scenario @links
    
    @When("^I want press link \"([^\"]*)\"$")
    public void user_press_link_by_contents(String arg1) throws Throwable {
        driver.findElement(By.linkText(arg1)).click();
    }
    @When("^I want to return to the previous page$")
    public void user_press_link_back_page() throws Throwable {
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Back")).click();
    }
    
    // use for scenario @selects
    
    @When("^I want select combobox \"([^\"]*)\"$")
    public void user_select_any_option(String combotype) {
    	switch (combotype) {
    	case  "s1Id":
    		driver.findElement(By.id("s1Id")).click();
    		driver.findElement(By.id("id3")).click();
    	case  "s2Id":
    		Select option2 = new Select(driver.findElement(By.id("s2Id")));
    		option2.selectByVisibleText("o2");
    	case  "s3Id":
    		Select option3 = new Select(driver.findElement(By.id("s3Id")));
    		option3.selectByIndex(3);
    	case  "s4Id":
    		Select option4 = new Select(driver.findElement(By.id("s4Id")));
    		option4.selectByValue("o1val");
    	case  "s1":
    		driver.findElement(By.id("s1")).sendKeys("Email");
    	}
    }
    // use for scenario @frames
    @Then("^I want click in link frame \"([^\"]*)\"$")
    public void user_press_link_frame(String frame) {
    	switch (frame) {
    	case "select test":
    		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]")));
    		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/a[4]")).click();
        case "react test":
        	driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
        	driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/a[9]")).click();
    	}       	
    }
    @When("^I want click in button Click Me$")
    public void user_press_button_click_me() {
    	driver.findElement(By.xpath("/html/body/input[2]")).click();
    }
    // use for scenario @clicks
    
    @When("^I want click in button \"([^\"]*)\"$")
    public void user_press_click_in_button(String clicks) {
    	switch (clicks) {
    	case "click me":
    		driver.findElement(By.xpath("/html/body/form/input[3]")).click();
    	case "dblclick me":
    		Actions action = new Actions(driver);
    		WebElement element = driver.findElement(By.xpath("/html/body/form/input[2]"));
    		action.doubleClick(element).perform();
    	case "right click me":
    		Actions right_click = new Actions(driver);
    		WebElement link = driver.findElement(By.xpath("/html/body/form/input[4]"));
    		right_click.contextClick(link).perform();
    	}
    }
    // use for scenario @alerts
    
    @When("^I want search button and \"([^\"]*)\"$")
    public void user_press_alert(String alert) {
    	switch (alert) {
    	case "Click For Confirm":
    		driver.findElement(By.xpath("/html/body/form/input[1]")).click();
    		driver.switchTo().alert().accept();
    	case "Click For Confirm Cancel":
    		driver.findElement(By.xpath("/html/body/form/input[1]")).click();
    		driver.switchTo().alert().dismiss();
    	}
    }
    // use for scenario @text
    
    @When("^I want search button and Click For Prompt$")
    public void user_press_alert_text() {
    		driver.findElement(By.xpath("//html/body/form/input[1]")).click();
    		driver.switchTo().alert().sendKeys("Hola Mundo");
    		driver.switchTo().alert().accept();    	
    		String message = driver.findElement(By.xpath("/html/body/form/input[2]")).getAttribute("value");	
    		System.out.println(message);
    		}
    // use for scenario @text
    @When("^I want click in link for new tab")
    public void user_open_new_tab() {
    	driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/a[8]")).click();
    	driver.switchTo().activeElement();
    	driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/a[1]")).click();
    	
    	}
    }
