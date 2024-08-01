package Tests;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Drivers.PageDriver;
import Pages.RegistationPage;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;


public class RegistationPageTest extends CommonMethods {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		driver.manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		timeOut();
		report=ExtentFactory.getInstance();
		parentTest=report.createTest("<p style=\"color:#FF6000;font-size:13px\"><b>Create User</b></p>").assignAuthor("SQ Team").assignDevice("Laptop");	
	}
	@Test
	public void createReg() throws InterruptedException, IOException {
		childTest=parentTest.createNode("<p style=\"color:#3E96E7;font-size:13px\"><b>New User</b></p>");
		RegistationPage reg=new RegistationPage(childTest);
		reg.registation();
		timeOut();
	}
	@AfterClass
	public void reportHtml() {
		report.flush();
	}
}
