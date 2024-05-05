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
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.aventstack.extentreports.ExtentTest;
import java.util.regex.*;

public class employeeCareerDevelopment {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	ExtentReports extent = new ExtentReports();
	
	loginTests login = new loginTests();
	
public boolean employeeCareerDevelopment08(){
    	
    	ExtentTest test = extent.createTest("Login");
    	extent.attachReporter(spark);
    	
    	System.out.println("TC_08_Test to check whether user is able to view list of employees having career development plan");
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver=login.loginSteps(driver);
    	
    	//click on career development
    	    	
    	driver.findElement(By.xpath("//a[@data-automation-id='menu_succession & development_individualDevelopmentPlans' and @class=' main-menu-item-1']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       	try {
    		Thread.sleep(15000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       	//view appraisal
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       	String str=driver.findElement(By.xpath("(//td[@name='listField.name'])[2]//span")).getText();
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//       	System.out.println(str);
    	String regex = "^[A-Za-z]+\s[A-Za-z]+$";
    	Pattern p = Pattern.compile(regex); 
    	Matcher m = p.matcher(str); 
    	boolean isName=m.matches();
       	
		
        if (isName==true) {
            driver.quit();
            return true;

        }else {
            
        	driver.quit();           	
	        return false;
        }

	}

}
