package com.nxtgenai.jobportal;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nxtgenai.jobportalapi.JobPortalAPI;
import com.nxtgenai.listeners.ExtentListeners;
import com.nxtgenai.setup.BaseTest;

import io.restassured.response.Response;

public class UpdatedJobDescription extends BaseTest{
	
	@Test
	public void updateJobDescription() {		
		Response response = JobPortalAPI.updateJobDescription(10, "Data Science", "To develop Data Science application");
		
		response.prettyPrint();		
		
		Assert.assertEquals(response.getStatusCode(), 200,"Status code is incorrect");
		Reporter.log("Status Code is verified successfully as : "+response.getStatusCode());
		ExtentListeners.extentTest.log(Status.PASS, "Status Code is verified successfully as : "+response.getStatusCode());
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 ", "Status line is incorrect");
		Reporter.log("Status Line is verified successfully as :"+response.getStatusLine());
		ExtentListeners.extentTest.log(Status.PASS, "Status Line is verified successfully as : "+response.getStatusLine());
		
		Assert.assertEquals(response.header("Content-Type"),"application/json", "Content Type is incorrect");
		Reporter.log("Content-Type is verified successfully as : "+response.header("Content-Type"));
		ExtentListeners.extentTest.log(Status.PASS, "Content-Type is verified successfully as : "+response.header("Content-Type"));
	}
}
