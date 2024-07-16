

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Variables.configProperties;

import com.aventstack.extentreports.*;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class employeeLogin {
	
//	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
//	ExtentReports extent = new ExtentReports();
/*	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Create a pulsating effect around the element
	    js.executeScript(
	        "var rect = arguments[0].getBoundingClientRect();" +
	        "var pulse = document.createElement('div');" +
	        "pulse.style.position = 'absolute';" +
	        "pulse.style.border = '3px solid red';" +
	        "pulse.style.borderRadius = '50%';" +
	        "pulse.style.width = (rect.width + 10) + 'px';" + // Slightly larger pulse
	        "pulse.style.height = (rect.height + 10) + 'px';" +
	        "pulse.style.left = (rect.left + window.scrollX - 5) + 'px';" + // Centering the pulse
	        "pulse.style.top = (rect.top + window.scrollY - 5) + 'px';" +
	        "pulse.style.zIndex = '9999';" +
	        "pulse.style.pointerEvents = 'none';" +
	        "pulse.style.boxShadow = '0 0 10px rgba(255, 0, 0, 0.5)';" +
	        "pulse.style.transition = 'transform 0.3s ease-in-out, opacity 0.5s';" +
	        "document.body.appendChild(pulse);" +
	        "pulse.style.transform = 'scale(1.2)';" +
	        "setTimeout(function() { pulse.style.transform = 'scale(1)'; }, 150);" +
	        "setTimeout(function() { pulse.style.opacity = '0'; }, 1000);" + // Shorter fade-out
	        "setTimeout(function() { document.body.removeChild(pulse); }, 1500);", // Removing the pulse from the DOM
	        element
	    );
	}*/
	
	public WebDriver loginSteps(WebDriver driver) {
		
		
		
        driver.manage().window().maximize();
        
        
        driver.get(configProperties.property.getProperty("LoginUrl"));
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
//        highlightElement(driver, driver.findElement(By.xpath("//input[@name='txtUsername']")));
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(configProperties.property.getProperty("ValidUsername1"));
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        highlightElement(driver, driver.findElement(By.xpath("//input[@name='txtPassword']")));
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(configProperties.property.getProperty("ValidPass1"));
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        highlightElement(driver, driver.findElement(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return driver;
		
	}
	
	
	public boolean login01(){
		
//		ExtentTest test = extent.createTest("Login");
//		extent.attachReporter(spark);
		
		System.out.println("TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.");
		
		WebDriver driver = new ChromeDriver();
		driver=loginSteps(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url1 = driver.getCurrentUrl();
        
        if (url1.contains("dashboard")) {
            driver.quit();
            return true;

        }else {

        	return false;
        	
        }
	}
	
public boolean login02(){
		
//		ExtentTest test = extent.createTest("Login");
//		extent.attachReporter(spark);
		
		System.out.println("TC_02_Test to check whether user is able to login after entering incorrect username and password.");
		
		WebDriver driver = new ChromeDriver();
//		driver=loginSteps(driver);
		
		driver.manage().window().maximize();
        
        
        driver.get(configProperties.property.getProperty("LoginUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(configProperties.property.getProperty("InValidUsername1"));
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(configProperties.property.getProperty("InValidPass1"));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//        String url1 = driver.getCurrentUrl();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	String actualPrompt=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		} catch (NoSuchElementException e) {
			return false;
		}
		String actualPrompt=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        if (actualPrompt.contains("Invalid Credentials") || actualPrompt.contains("Please solve the problem to proceed.")) {
            driver.quit();
            return true;

        }else {
            
        	driver.quit();           	
	        return false;
        }
        
	}
        
}
