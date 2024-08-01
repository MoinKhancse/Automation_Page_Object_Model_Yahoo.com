package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Drivers.PageDriver;
import Utilities.CommonMethods;
import Utilities.GetScreenShot;

public class RegistationPage extends CommonMethods {
	
	ExtentTest test;
	
	public RegistationPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
		@FindBy(xpath="//a[@id='createacc']")
	})
	WebElement createAccount;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-firstName']")
	})
	WebElement firstName;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-lastName']")
	})
	WebElement lastName;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-userId']")
	})
	WebElement email;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-password']")
	})
	WebElement password;
	
	@FindBys({
		@FindBy(xpath="//select[@id='usernamereg-month']")
	})
	WebElement month;
	
	@FindBys({
		@FindBy(xpath="//option[@value='3']")
	})
	WebElement march;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-day']")
	})
	WebElement day;
	
	@FindBys({
		@FindBy(xpath="//input[@id='usernamereg-year']")
	})
	WebElement year;
	
	@FindBys({
		@FindBy(xpath="//button[@id='reg-submit-button']")
	})
	WebElement submit;
	
	public void passCass(String message) {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
	}
	
	@SuppressWarnings("unused")
	public void passCassWithSC(String message,String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> "+message+" </b></p>");
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+ scName+"");
		String dest = System.getProperty("user.dir")+"\\Screen Shots\\"+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	@SuppressWarnings("unused")
	public void screenShot(String scName) throws IOException {
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+ scName+"");
		String dest = System.getProperty("user.dir")+"\\Screen Shots\\"+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	@SuppressWarnings("unused")
	public void failCass(String message,String scName) throws IOException {
		test.fail("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t=new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+ scName+"");
		String dest = System.getProperty("user.dir")+"\\Screen Shots\\"+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void registation() throws InterruptedException, IOException {
		test.info("Click Button");
		createAccount.click();
		passCassWithSC("You have successfully click ", "Registation Page");
		timeOut();
		if(firstName.isDisplayed()) {
			firstName.sendKeys("moin");
			passCass("You have Successfully Fast Name");
			timeOut();
			if(lastName.isDisplayed()) {
				lastName.sendKeys("khan");
				passCass("You have Successfully Last Name");
				timeOut();	
				if(email.isDisplayed()) {
					email.sendKeys("moinkhan.cse");
					passCass("You have Successfully email");
					timeOut();
					if(password.isDisplayed()) {
						password.sendKeys("01717511288");
						passCass("You have Successfully password");
						timeOut();				
						if(month.isDisplayed()) {
							month.click();
							timeOut();
							if(march.isDisplayed()) {
								march.click();
								timeOut();
								if(day.isDisplayed()) {
									day.sendKeys("26");
									timeOut();
									if(year.isDisplayed()) {
										year.sendKeys("1997");
										passCass("You have Successfully Date Of Birth");
										timeOut();
									}
								}
							}
						}
					}
				}
			}
			screenShot("Registation");
			test.info("Please click button");
		}
		submit.click();
		passCassWithSC("You successfully click ", "Registation Success");
	}
}
