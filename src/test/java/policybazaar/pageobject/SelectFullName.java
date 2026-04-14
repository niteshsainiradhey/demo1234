package policybazaar.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFullName 
{
public WebDriver ldriver;
	
	public SelectFullName(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	@FindBy(id ="fullName") WebElement fullName;
	@FindBy(id ="mobile") WebElement mobile;
	@FindBy(xpath  ="//span[text()='Continue ›']") WebElement namecontinue;
	
	public void fullName(String fullName1)
	{
		fullName.sendKeys(fullName1);
	}
	public void getMobile(String mobile1)
	{
		mobile.sendKeys(mobile1);
	}
	public void nameNontinue()
	{
		namecontinue.click();
	}
}


