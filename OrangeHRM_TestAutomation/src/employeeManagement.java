import org.openqa.selenium.By;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
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

import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;

public class employeeManagement {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	
	employeeLogin login = new employeeLogin();
	
	public static String dateManipulation(int addMonth) {
		
		DateFormat dateFormat = new SimpleDateFormat("Y-dd-MM");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, addMonth);
		String result = dateFormat.format(cal.getTime());
		return result;
	}
	
    public boolean employeeManagement03(){
		
		ExtentTest test = extent.createTest("Login");
		extent.attachReporter(spark);
		
		System.out.println("TC_03_Test to check whether user is able to add new employee with all the appropriate details");
		
		WebDriver driver = new ChromeDriver();
		
		driver=login.loginSteps(driver);
		
		//click Employee list button
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList' and @class='top-level-menu-item']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		//click '+' icon
		driver.findElement(By.xpath("//div[@data-tooltip='Add Employee']//i[@class='material-icons'] ")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
		
		//Enter Firstname
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(configProperties.property.getProperty("FirstName1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Enter Middlename
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(configProperties.property.getProperty("MiddleName1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Enter Lastname
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(configProperties.property.getProperty("LastName1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Enter joined date
		driver.findElement(By.xpath("//button[@class='btn date-picker-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='picker__day picker__day--infocus' and text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Selecting Location
		driver.findElement(By.xpath("//div[@class='input-group-append']//i[@class='material-icons' and text()='arrow_drop_down']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[@class='text' and text()='India Office']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Personal Details page
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='input-field col s12 m12 l4']//input[@id='ssn']")).sendKeys(configProperties.property.getProperty("AadharSSN"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(configProperties.property.getProperty("Emp_DOB"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Marital Status
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[normalize-space()='Married']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
//		WebElement w1=driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']"));
//		Select dropdown1=new Select(w1);
//		dropdown1.selectByVisibleText("Single");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Gender
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[normalize-space()='Male']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//Nationality
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[normalize-space()='Indian']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//next button
		driver.findElement(By.xpath("//button[@ng-show='!vm.showFinishButton']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Employment Details page
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='probation_end_date']/ancestor::div[@name='dateForm']//button[@class='btn date-picker-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='probation_end_date']/ancestor::div[@name='dateForm']//div[@class='picker__day picker__day--infocus' and text()='28']")).click();//apply date logic
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='date_of_permanency']/ancestor::div[@name='dateForm']//button[@class='btn date-picker-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='date_of_permanency']/ancestor::div[@name='dateForm']//div[@title='Next month']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//input[@id='date_of_permanency']/ancestor::div[@name='dateForm']//div[@role='gridcell' and text()='1'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Job title
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select-dropdown']//button[@role='combobox']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[normalize-space()='Intern - Software Developer']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//employment status
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select-dropdown']//button[@data-id='employment_status_id']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[normalize-space()='Full-Time Contract']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//job category
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select-dropdown']//button[@data-id='job_category_id']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[normalize-space()='Professionals']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//sub unit
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select-dropdown']//button[@data-id='subunit_id']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[normalize-space()='Quality assurance (QA)']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//comments
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("This is Full time QA professional");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Date formatting for contract start and end date
		DateFormat dateFormat = new SimpleDateFormat("Y-dd-MM");
		Date date = new Date();
		
		//Contract Start Date		
		String currentDate = dateFormat.format(date);
//		System.out.println(currentDate);
		driver.findElement(By.xpath("//input[@id='contract_start_date']")).sendKeys(currentDate);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Contract End Date
		String endDate = dateManipulation(12);
//		System.out.println(endDate);
		driver.findElement(By.xpath("//input[@id='contract_end_date']")).sendKeys(endDate);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Next button
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Onboarding page
		
		//event template
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@class='select-dropdown']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[normalize-space()='Onboarding - India']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Save button
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Verification
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String emp_name=driver.findElement(By.xpath("//div[@class='emp-name']")).getText();
//		System.out.println(emp_name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
		String fname = configProperties.property.getProperty("FirstName1");
		String mname = configProperties.property.getProperty("MiddleName1");
		String lname = configProperties.property.getProperty("LastName1");
		String name = fname + " " + mname + " " + lname;
		
		
        if (emp_name.contains(name)) {
            driver.quit();
            return true;

        }else {
            
        	driver.quit();           	
	        return false;
        }
    
    
			
}
    
    public boolean employeeManagement04(){
		
		ExtentTest test = extent.createTest("Login");
		extent.attachReporter(spark);
		
		System.out.println("TC_04_Test to check whether user is able to search an employee by name");
		
		WebDriver driver = new ChromeDriver();
		
		driver=login.loginSteps(driver);
		
		//click Employee list button
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList' and @class='top-level-menu-item']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		//search bar
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(configProperties.property.getProperty("EmpInitials1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//select employee
		driver.findElement(By.xpath("//a[contains(text(),'Brad  Bellic')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//verification
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ActualUrl=driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        if (ActualUrl.contains("profile")) {
            driver.quit();
            return true;

        }else {
            
        	driver.quit();           	
	        return false;
        }
    
    
			
    }
    
    public boolean employeeManagement05(){
    	
    	ExtentTest test = extent.createTest("Login");
    	extent.attachReporter(spark);
    	
    	System.out.println("TC_05_Test to check whether user is able to open employee details by clicking on name");
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver=login.loginSteps(driver);
    	
    	//click Employee list button
    	driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList' and @class='top-level-menu-item']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       	try {
    		Thread.sleep(6000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	//select employee
    	driver.findElement(By.xpath("//a[contains(text(),'Peter  Anderson ')]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//verification
    	try {
    		Thread.sleep(8000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	String ActualUrl=driver.getCurrentUrl();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	String ActualName=driver.findElement(By.xpath("//div[@class='emp-name']")).getText();
//    	System.out.println(ActualName);
    	
    	if (ActualUrl.contains("profile") && ActualName.contains("Peter Anderson")) {
    		driver.quit();
    		return true;
    		
    	}else {
    		
    		driver.quit();           	
    		return false;
    	}
    	
    	
    	
    }

}
