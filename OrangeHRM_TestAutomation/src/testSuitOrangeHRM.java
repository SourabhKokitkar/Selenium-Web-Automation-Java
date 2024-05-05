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
	public void TC02_Login(){
		
		ExtentTest test = extent.createTest("Login");
		loginTests login = new loginTests();
		boolean status = login.login02();
		
		if(status==true) {
			test.log(Status.PASS, "TC_02_Test to check whether user is able to login after entering incorrect username and password.");
			test.pass("User prompted with an error message ");
		}else {
			test.log(Status.FAIL, "TC_02_Test to check whether user is able to login after entering incorrect username and password.");
			test.fail("User able to login");
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
	
	@Test()
	public void TC05_EmployeeManagement(){
		
		ExtentTest test = extent.createTest("Employee Management");
		employeeManagement emp = new employeeManagement();
		boolean status = emp.employeeManagement05();
		
		if(status==true) {
			test.log(Status.PASS, "TC_05_Test to check whether user is able to open employee details by clicking on name");
			test.pass("User able to view employee details successfully");
		}else {
			test.log(Status.FAIL, "TC_05_Test to check whether user is able to open employee details by clicking on name");
			test.fail("Unable to view employee details");
		}
		
	}
	
	@Test()
	public void TC06_EmployeePerformance(){
		
		ExtentTest test = extent.createTest("Employee Performance");
		employeePerformance emp = new employeePerformance();
		boolean status = emp.employeePerformance06();
		
		if(status==true) {
			test.log(Status.PASS, "TC_06_Test to check whether user is able to initiate appraisal for an employee");
			test.pass("User able to initiate appraisal process for employee successfully");
		}else {
			test.log(Status.FAIL, "TC_06_Test to check whether user is able to initiate appraisal for an employee");
			test.fail("Unable to initiate appraisal process");
		}
		
	}
	
	
	@Test()
	public void TC07_EmployeePerformance(){
		
		ExtentTest test = extent.createTest("Employee Performance");
		employeePerformance emp = new employeePerformance();
		boolean status = emp.employeePerformance07();
		
		if(status==true) {
			test.log(Status.PASS, "TC_07_Test to check whether user is able to initiate appraisal for an employee");
			test.pass("User able to view appraisal ratings for employee successfully");
		}else {
			test.log(Status.FAIL, "TC_07_Test to check whether user is able to initiate appraisal for an employee");
			test.fail("Unable to view appraisal details");
		}
		
	}
	
	
	@Test()
	public void TC08_EmployeeCareerDevelopment(){
		
		ExtentTest test = extent.createTest("Employee Performance");
		employeeCareerDevelopment emp = new employeeCareerDevelopment();
		boolean status = emp.employeeCareerDevelopment08();
		
		if(status==true) {
			test.log(Status.PASS, "TC_08_Test to check whether user is able to view list of employees having career development plan");
			test.pass("User successfully able to view employee list who have career development plan");
		}else {
			test.log(Status.FAIL, "TC_08_Test to check whether user is able to view list of employees having career development plan");
			test.fail("Unable to view employee list who have career development plan");
		}
		
	}
	
	
	@Test()
	public void TC09_EmployeeRequestDesk(){
		
		ExtentTest test = extent.createTest("Employee Performance");
		employeeRequestDesk emp = new employeeRequestDesk();
		boolean status = emp.employeeRequestDesk09();
		
		if(status==true) {
			test.log(Status.PASS, "TC_09_Test to check whether user is able to submit resignation request with urgent priority");
			test.pass("User successfully able submit resignation request");
		}else {
			test.log(Status.FAIL, "TC_09_Test to check whether user is able to submit resignation request with urgent priority");
			test.fail("Unable to submit resignation request");
		}
		
	}
	
	@Test()
	public void TC10_employeeRecruitment(){
		
		ExtentTest test = extent.createTest("Employee Performance");
		employeeRecruitment emp = new employeeRecruitment();
		boolean status = emp.employeeRecruitment10();
		
		if(status==true) {
			test.log(Status.PASS, "TC_10_Test to check whether user is able to hire the shortlisted candidate");
			test.pass("User successfully able hire shortlisted candidate");
		}else {
			test.log(Status.FAIL, "TC_10_Test to check whether user is able to hire the shortlisted candidate");
			test.fail("Unable to hire shortlisted candidate");
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
