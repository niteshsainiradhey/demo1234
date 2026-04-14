package policybazaar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthInsuranceAndSelf 
{
	public WebDriver ldriver;
	
	public HealthInsuranceAndSelf(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	@FindBy(xpath="//p[text()='Health']") WebElement health;
	@FindBy(xpath="//button[text()='Continue › ']") WebElement continuehealth;
	
	public void getHealth()
	{
		health.click();
	}
	public void continueHealth()
	{
		continuehealth.click();
	}
	
}
