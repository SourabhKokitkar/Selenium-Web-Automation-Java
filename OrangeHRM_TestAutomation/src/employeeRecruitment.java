import org.openqa.selenium.By;
import java.util.ArrayList;
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
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.aventstack.extentreports.ExtentTest;
import java.util.regex.*;

public class employeeRecruitment {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	
	loginTests login = new loginTests();
	
	public boolean employeeRecruitment10(){
    	
    	ExtentTest test = extent.createTest("Login");
    	extent.attachReporter(spark);
    	
    	System.out.println("TC_10_Test to check whether user is able to hire the shortlisted candidate");
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver=login.loginSteps(driver);
    	
    	//click on request desk
    	driver.findElement(By.xpath("//a[@data-automation-id='menu_recruitment_viewCandidates' and @class=' main-menu-item-1']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       	try {
    		Thread.sleep(15000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	
       	//Recruitment page
       	//shortlisted
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       	driver.findElement(By.xpath("//p[normalize-space()='Shortlisted']")).click();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       	try {
    		Thread.sleep(4500);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	String candidateName=driver.findElement(By.xpath("(//a[@class='oxd-table-cell-link'])[1]")).getText();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
       	driver.findElement(By.xpath("(//div[@class='selected-content'][normalize-space()='Shortlisted'])[1]")).click();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       	try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	//select option
       	driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='Hired']")).click();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
 
       	try {
    		Thread.sleep(5000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	
       	//go to hired
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       	driver.findElement(By.xpath("//p[normalize-space()='Hired']")).click();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       	List<WebElement> empList = driver.findElements(By.xpath("//a[@class='oxd-table-cell-link']"));
       	int count=empList.size();
//       	System.out.println(count);    	
//       	System.out.println(candidateName);
       	String[] candidateNames = new String[count];
       	
       	//verification
       	int j=0;
       	for(int i=0;i<count;i++) {
       		String xpath = "(//a[@class='oxd-table-cell-link'])["+(i+1)+"]";
       		candidateNames[i]=driver.findElement(By.xpath(xpath)).getText();
//       		System.out.println(candidateNames[i]);
       		if(candidateNames[i].equalsIgnoreCase(candidateName)) {
       			
       			j=1;
//       			System.out.println(candidateNames[i]);
       			break;
       		}
       	}
       	
       	if(j==1) {
   			driver.quit();
            return true;
   		}
   		else {
   			driver.quit();           	
	        return false;
   		}
       	
	}

}
