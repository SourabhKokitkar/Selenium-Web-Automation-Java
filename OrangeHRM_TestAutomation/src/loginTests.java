import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;

import java.time.Duration;

import org.junit.Test;


public class loginTests {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	
	public WebDriver loginSteps(WebDriver driver) {
		
		
		
        driver.manage().window().maximize();
        
        
        driver.get("https://orangeuser01-trials712.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("AVo@9ta2FF");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return driver;
		
	}
	
	
	public boolean login01(){
		
		ExtentTest test = extent.createTest("Login");
		extent.attachReporter(spark);
		
		System.out.println("TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.");
		
		WebDriver driver = new ChromeDriver();
		driver=loginSteps(driver);
		
        String url1 = driver.getCurrentUrl();
        
        
//        SoftAssert s1 = new SoftAssert();
//        s1.assertEquals(flag1,0,"Incorrect login or password");
//        driver.quit();
//        s1.assertAll();
        
        if (url1.contains("dashboard")) {
            driver.quit();
//            s1.assertAll();
            return true;

        }else {
//        	System.out.println("fail block");
//        	int flag1=1;
//			s1.assertEquals(flag1,0,"Incorrect login or password");
            driver.quit();
//        	s1.assertAll();
        	
	        return false;
        }
	}
        
}
