package policybazaar.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import policybazaar.testcase.BaseClass;

public class ExtentReport extends BaseClass implements ITestListener
{
	ExtentSparkReporter createReport; 
	 ExtentReports createTest; 
	 ExtentTest createLog; 
	 public void setup() 
	 { 
		 ReadConfiguration r1=new ReadConfiguration();
	  createReport=new ExtentSparkReporter("MyProjectReport.html"); 
	  createTest=new ExtentReports(); 
	  createTest.attachReporter(createReport); //hello
	   
	  createTest.setSystemInfo("OperatingSystem", "Windown"); 
	  createTest.setSystemInfo("Browesr", r1.getBrowser()); 
	  createTest.setSystemInfo("BrowesrVersion", "181.91.22.01"); 
	  createTest.setSystemInfo("MACAddress", "00-B0-D0-63-C2-26"); 
	  createTest.setSystemInfo("Environment", "Testing"); 
	  createTest.setSystemInfo("User Name", "Ronak Saini"); 
	   
	   
	 
	  createReport.config().setDocumentTitle("MyprojectReportInfo"); 
	  createReport.config().setReportName("Module-6-Reports"); 
	  createReport.config().setTheme(Theme.DARK); 
	   
	 }
	public void onStart(ITestContext Result) 
	{
		setup();
	}

	public void onTestSuccess(ITestResult Result)
	{
		createLog=createTest.createTest(Result.getName()); 
		createLog.log(Status.PASS,MarkupHelper.createLabel("TestCase pass", ExtentColor.GREEN)); 
	}

	public void onTestFailure(ITestResult Result)
	{
		try {
			screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path="C:\\Users\\DELL\\Desktop\\WorkShop\\Feb\\policybazaar\\screenshot\\p.png";
		createLog=createTest.createTest(Result.getName()); 
		createLog.log(Status.FAIL,MarkupHelper.createLabel("TestCase Failed", ExtentColor.RED)); 
		createLog.fail("capture_fail_testcase-"+createLog.addScreenCaptureFromPath(path));
		
	}

	public void onTestSkipped(ITestResult Result)
	{
		createLog=createTest.createTest(Result.getName()); 
		createLog.log(Status.SKIP,MarkupHelper.createLabel("TestCase Skipped", ExtentColor.YELLOW)); 
	}
	public void onFinish(ITestContext Result) 
	{
		createTest.flush(); 
	}
}
