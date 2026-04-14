package policybazaar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectAge 
{
public WebDriver ldriver;
	
	public SelectAge(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	@FindBy(id="Self") WebElement self;
	@FindBy(xpath ="//button[text()='Continue › ']") WebElement selfcontinue;
	
	public void  ageDrop(String age)
	{
		Select sc=new Select(self);
		sc.selectByVisibleText(age);
	}
	public void selfContinue()
	{
		selfcontinue.click();
	}
}
