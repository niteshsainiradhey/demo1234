package policybazaar.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import policybazaar.utilities.DataDrivenTesting;
import policybazaar.utilities.ReadConfiguration;

public class BaseClass 
{
	public static WebDriver driver;
	ReadConfiguration r=new ReadConfiguration();
	String browser=r.getBrowser();//chrome
	String url=r.getUrl();//
	
	
	@BeforeTest
	void setUp()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver=null;
		}
	}
	public void screenshot() throws IOException
	{
		TakesScreenshot tsc=(TakesScreenshot)driver;	
		File a3=tsc.getScreenshotAs(OutputType.FILE);
		File a4=new File("C:\\Users\\DELL\\Desktop\\WorkShop\\Feb\\policybazaar\\screenshot\\p.png");
		FileUtils.copyFile(a3, a4);
	}
	@DataProvider(name="CityDataPro")
	public String[][]CityDataPro1() throws Exception
	{
		String file_name="C:\\Users\\DELL\\Desktop\\city.xlsx";
		int rows=DataDrivenTesting.getRowCount(file_name, "Sheet1");
		int cols=DataDrivenTesting.getCellCount(file_name, "Sheet1");
		
		String s1[][]=new String[rows-1][cols];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				s1[i-1][j]=DataDrivenTesting.getCellValue(file_name, "Sheet1", i, j);
			}
		}
		return s1;
		
	}
	@DataProvider(name="DataPro")
	public String[][]getData() throws Exception
	{
		String file_name="C:\\Users\\DELL\\Desktop\\age.xlsx";
		int rows=DataDrivenTesting.getRowCount(file_name, "Sheet1");
		int cols=DataDrivenTesting.getCellCount(file_name, "Sheet1");
		
		String s1[][]=new String[rows-1][cols];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				s1[i-1][j]=DataDrivenTesting.getCellValue(file_name, "Sheet1", i, j);
			}
		}
		return s1;
		
	}
}
