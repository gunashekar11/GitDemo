package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportsNG;

public class Listeners extends Base implements ITestListener
{
	ExtentTest test;
	ExtentReports extend=ExtentReportsNG.getReports();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test = extend.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		 
		
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test is Passed!!");
		
	}


	public void onTestFailure(ITestResult result) {
		
		// For extend reports for only sequential execution
		extentTest.get().fail(result.getThrowable());
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		
		try 
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
		}
		try
		{
			extentTest.get().addScreenCaptureFromPath(screenshot(testMethodName, driver),testMethodName);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extend.flush();
	}

	
}
