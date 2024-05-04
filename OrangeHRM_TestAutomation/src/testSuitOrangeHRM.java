import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class testSuitOrangeHRM {
	
	// directory where output is to be printed
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	

	@Test()
	public void TC01_Login(){
		
		ExtentTest test = extent.createTest("Login");
//		Reporter.log("TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.",true);
		loginTests login = new loginTests();
		boolean status = login.login01();
		
		if(status==true) {
            test.log(Status.PASS, "TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.");
    		test.pass("User able to login successfully");
		}else {
			test.log(Status.FAIL, "TC_01_Test to check whether user is able to login succefully after entering appropriate username and password.");
    		test.fail("Unable to login, Icorrect username or password");
		}
				
	}
	
	@Test()
	public void TC03_EmployeeManagement(){
		
		ExtentTest test = extent.createTest("Employee Management");
		employeeManagement emp = new employeeManagement();
		boolean status = emp.employeeManagement03();
		
		if(status==true) {
            test.log(Status.PASS, "TC_03_Test to check whether user is able to add new employee with all the appropriate details");
    		test.pass("User able to add new employee successfully");
		}else {
			test.log(Status.FAIL, "TC_03_Test to check whether user is able to add new employee with all the appropriate details");
    		test.fail("Unable to add employee, Icorrect details provided");
		}
				
	}
	
	@Test()
	public void TC04_EmployeeManagement(){
		
		ExtentTest test = extent.createTest("Employee Management");
		employeeManagement emp = new employeeManagement();
		boolean status = emp.employeeManagement04();
		
		if(status==true) {
			test.log(Status.PASS, "TC_04_Test to check whether user is able to search an employee by name");
			test.pass("User able to search an employee successfully");
		}else {
			test.log(Status.FAIL, "TC_04_Test to check whether user is able to search an employee by name");
			test.fail("Unable to search employee, please check Name/id");
		}
		
	}
	
	
	@BeforeTest
	public void beforeTest() {
		extent.attachReporter(spark);
	}
	
	@AfterTest
	public void  afterTest() {
		extent.flush();
	}
	
	

	
 
}
