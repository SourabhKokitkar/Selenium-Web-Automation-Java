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


public class employeeLogin {
	
//	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
//	ExtentReports extent = new ExtentReports();
	
	public WebDriver loginSteps(WebDriver driver) {
		
		
		
        driver.manage().window().maximize();
        
        
        driver.get(configProperties.property.getProperty("LoginUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(configProperties.property.getProperty("ValidUsername1"));
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(configProperties.property.getProperty("ValidPass1"));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return driver;
		
	}
	
	
	public boolean login01(){
		
//		ExtentTest test = extent.createTest("Login");
//		extent.attachReporter(spark);
		
		System.out.println("TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.");
		
		WebDriver driver = new ChromeDriver();
		driver=loginSteps(driver);
		
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
