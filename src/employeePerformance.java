

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

import Variables.configProperties;

import com.aventstack.extentreports.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;

public class employeePerformance {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	
	employeeLogin login = new employeeLogin();
	
	public boolean employeePerformance06(){
    	
    	ExtentTest test = extent.createTest("Login");
    	extent.attachReporter(spark);
    	
    	System.out.println("TC_06_Test to check whether user is able to initiate appraisal for an employee");
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver=login.loginSteps(driver);
    	
    	//click on performance
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.xpath("//li[@id='left_menu_item_18']//a[1]//span[1]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       	try {
    		Thread.sleep(6000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	
       	//taking count to verify later
       	String str=driver.findElement(By.xpath("//li[@class='summary']")).getText();
       	char[] countArray = str.toCharArray();
       	int initialcount=Integer.parseInt(String.valueOf(countArray[countArray.length - 1]));
       	
    	//add appraisal button
    	driver.findElement(By.xpath("//a[@id='add_appraisal']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	//verification
    	try {
    		Thread.sleep(10000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	//Details page
    	
    	//emp name
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	WebElement iframe = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
    	driver.switchTo().frame(iframe);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	driver.findElement(By.xpath("//input[@name='employeeAppraisal[emp_name][empName]']")).sendKeys(configProperties.property.getProperty("EmpInitials2"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	try {
    		Thread.sleep(5000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	List<WebElement> empList = driver.findElements(By.xpath("//div[@class='ac_results']//div"));
//    	int suggestionCount = empList.size();
    	empList.get(2).click();
    	
    	//Description
    	driver.findElement(By.xpath("//textarea[@name='employeeAppraisal[description]']")).sendKeys("This is a dummy desciption");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//cycle
    	driver.findElement(By.xpath("//input[@class='select-dropdown']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(By.xpath("//span[normalize-space()='2023 Annual Appraisal']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//from
    	driver.findElement(By.xpath("//input[@id='date_from']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(By.xpath("//table[@id='date_from_table']//div[@class='picker__day picker__day--infocus' and text()='1']")).click(); 
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//to
    	driver.findElement(By.xpath("//input[@id='date_to']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	int i=0;
    	do {
    		driver.findElement(By.xpath("//div[@title='Next month' and  @aria-controls='date_to_table']")).click();
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		i++;
    	}while(i<3);

    	driver.findElement(By.xpath("//table[@id='date_to_table']//div[@aria-label=\"2024-10-27\"]")).click(); //apply date logic here
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//due date
    	driver.findElement(By.xpath("//input[@id='date_due']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	int j=0;
    	do {
    		driver.findElement(By.xpath("//div[@title='Next month' and @aria-controls='date_due_table']")).click();
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		j++;
    	}while(j<3);
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(By.xpath("//table[@id='date_due_table']//div[@class='picker__day picker__day--infocus' and text()='28']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//next button
    	driver.findElement(By.xpath("//a[@id='saveBtn']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	//evaluators page
    	//save
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.xpath("//a[@id='saveBtn']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	//Ratings
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int k=1;k<28;) {
    		
    		String s = "(//a[@data-rating-text='4.5'])["+k+"]";
    		driver.findElement(By.xpath(s)).click();
    		k+=2;
    	}
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	//back to homepage
    	driver.findElement(By.xpath("//a[@data-automation-id='menu_home']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	//click on performance    	
    	driver.findElement(By.xpath("//li[@id='left_menu_item_18']//a[1]//span[1]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       	//taking count to verify later
       	String str2=driver.findElement(By.xpath("//li[@class='summary']")).getText();
       	char[] countArray2 = str2.toCharArray();
       	int finalcount=Integer.parseInt(String.valueOf(countArray2[countArray2.length - 1]));	    	
    	
    	if (finalcount>initialcount) {
    		driver.quit();
    		return true;
    		
    	}else {
    		
    		driver.quit();           	
    		return false;
    	}
    	
    	
    	
    }
	
	public boolean employeePerformance07(){
    	
    	ExtentTest test = extent.createTest("Login");
    	extent.attachReporter(spark);
    	
    	System.out.println("TC_07_Test to check whether user is able to view own appraisal info");
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver=login.loginSteps(driver);
    	
    	//click on performance
    	    	
    	driver.findElement(By.xpath("//li[@id='left_menu_item_18']//a[1]//span[1]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       	try {
    		Thread.sleep(6000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	//view appraisal
       	driver.findElement(By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    	driver.findElement(By.xpath("//td//span[normalize-space()='Aaron Hamilton']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       	
       	try {
    		Thread.sleep(6000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	//switch iframe
    	WebElement iframe = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
    	driver.switchTo().frame(iframe);
       	//fetch ratings
		String actualRating=driver.findElement(By.xpath("//div[@id='finalRatingValue']")).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
		if (actualRating.contains("_ _")) {
            driver.quit();
//            System.out.println("breaked");
            return true;

        }
		
		float rating=Float.parseFloat(actualRating);
		
        if (rating>=0 && rating<=5.0 ) {
            driver.quit();
            return true;

        }else {
            
        	driver.quit();           	
	        return false;
        }

	}
}
