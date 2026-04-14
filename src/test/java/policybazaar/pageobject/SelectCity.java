package policybazaar.pageobject;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCity 
{
public WebDriver ldriver;
	
	public SelectCity(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	@FindBy(id ="city") WebElement city;
	
	public void getCity(String city1)
	{
		city.sendKeys(city1,Keys.ENTER);
	}
}
