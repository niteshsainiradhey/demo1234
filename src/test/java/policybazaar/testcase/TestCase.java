package policybazaar.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import policybazaar.pageobject.HealthInsuranceAndSelf;
import policybazaar.pageobject.SelectAge;
import policybazaar.pageobject.SelectCity;
import policybazaar.pageobject.SelectFullName;
import policybazaar.utilities.DataDrivenTesting;

public class TestCase extends BaseClass
{
		@Test(priority = 0)
		void healthInsuranceAndSelf() throws Exception
		{
			driver.get(url);
			HealthInsuranceAndSelf healthinsuranceandself=new HealthInsuranceAndSelf(driver);
			healthinsuranceandself.getHealth();
			Thread.sleep(5000);
			healthinsuranceandself.continueHealth();
			
		}
		@Test(priority = 1,dataProvider = "DataPro")
		void selectAge(String age) throws Exception
		{
			SelectAge selectage=new SelectAge(driver);
			Thread.sleep(3000);
			selectage.ageDrop(age);
			selectage.selfContinue();
			
			
		}
		@Test(priority = 2,dataProvider = "CityDataPro")
		void selectCity(String city)
		{
			SelectCity selectcity=new SelectCity(driver);
			selectcity.getCity(city);
		}
		@Test(priority = 3,dataProvider = "fullbnameandmobile")
		void selectFullName(String fullname,String mobile)
		{
			SelectFullName selectfullname=new SelectFullName(driver);
			selectfullname.fullName(fullname);
			selectfullname.getMobile(mobile);
			
		}
		
		
		
		
}
