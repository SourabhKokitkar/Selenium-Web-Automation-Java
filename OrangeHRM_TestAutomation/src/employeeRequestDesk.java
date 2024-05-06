import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.aventstack.extentreports.ExtentTest;
import java.util.regex.*;

	public class employeeRequestDesk {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		
		employeeLogin login = new employeeLogin();
		
		public static String dateManipulation(int addDays) {
			
			DateFormat dateFormat = new SimpleDateFormat("Y-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, addDays);
			String result = dateFormat.format(cal.getTime());
			return result;
		}
		
		
		public boolean employeeRequestDesk09(){
	    	
	    	ExtentTest test = extent.createTest("Login");
	    	extent.attachReporter(spark);
	    	
	    	System.out.println("TC_09_Test to check whether user is able to submit resignation request with urgent priority");
	    	
	    	WebDriver driver = new ChromeDriver();
	    	
	    	driver=login.loginSteps(driver);
	    	
	    	//click on request desk
	    	driver.findElement(By.xpath("//a[@data-automation-id='menu_Request Desk_addRequest' and @class=' main-menu-item-1']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       	try {
	    		Thread.sleep(15000);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	       	//request type
	       	
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	       	driver.findElement(By.xpath("//input[@class='select-dropdown']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       	try {
	    		Thread.sleep(2500);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	       	driver.findElement(By.xpath("//span[normalize-space()='Resignation Request']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
	       	//next
	       	driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	       	
	       	//submit request page
	       	
	       	//Priority    
	       	try {
	    		Thread.sleep(5000);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	       	driver.findElement(By.xpath("//input[@value='Not Urgent']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       	driver.findElement(By.xpath("//span[normalize-space()='Urgent']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       	
	       	//Reason
	       	driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("This is a dummy description");
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
	       	
			//Date formatting for resolution and resignation date
			DateFormat dateFormat = new SimpleDateFormat("Y-MM-dd");
			Date date = new Date();
			
	       	//resolution date	       	
			String resolutionDate = dateManipulation(7);
	       	driver.findElement(By.xpath("//input[@id='resolutionDate']")).sendKeys(resolutionDate); 
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
	       	//resignation date
	       	String resignationDate = dateManipulation(14);
	       	driver.findElement(By.xpath("//input[@id='1']")).sendKeys(resignationDate);
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
	       	
	       	//submit
	       	driver.findElement(By.xpath("//a[normalize-space()='Submit']")).click();
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       	
	       	try {
	    		Thread.sleep(5000);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	       	
	       	//back to homepage
	    	driver.findElement(By.xpath("//a[@data-automation-id='menu_home']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	    	//click on request desk
	    	driver.findElement(By.xpath("//a[@data-automation-id='menu_Request Desk_addRequest' and @class='main-menu-item-1']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	    	//my requests
	    	driver.findElement(By.xpath("//a[@data-automation-id='menu_Request Desk_MyRequests']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	    	driver.findElement(By.xpath("//a[@data-automation-id='menu_Request Desk_viewMyGeneralRequests']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	       	try {
	    		Thread.sleep(5000);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	
	    	//verification
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	       	String actualRequest=driver.findElement(By.xpath("(//td[@name='listField.name'])[6]")).getText();
	       	String actualPriority=driver.findElement(By.xpath("(//td[@name='listField.name'])[5]")).getText();
	    	
			
	        if ((actualRequest.equalsIgnoreCase("Resignation Request")) && (actualPriority.equalsIgnoreCase("Urgent"))) {
	            driver.quit();
	            return true;
	
	        }else {
	            
	        	driver.quit();           	
		        return false;
	        }
	
		}
	
}
