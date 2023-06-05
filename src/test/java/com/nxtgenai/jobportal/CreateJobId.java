package com.nxtgenai.jobportal;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nxtgenai.jobportalapi.JobPortalAPI;
import com.nxtgenai.listeners.ExtentListeners;
import com.nxtgenai.setup.BaseTest;

import io.restassured.response.Response;


public class CreateJobId extends BaseTest {

	@Test
	public void createJobDetails() {	

		String jsonPath = ".\\src\\test\\resources\\testdata\\PostRequestCreateJobId.json";
		Response response = JobPortalAPI.createJobIdDetails(jsonPath);
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 201,"Status code is incorrect");
		Reporter.log("Status Code is verified successfully as : "+response.getStatusCode());
		ExtentListeners.extentTest.log(Status.PASS, "Status Code is verified successfully as : "+response.getStatusCode());
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 ", "Status line is incorrect");
		Reporter.log("Status Line is verified successfully as : "+response.getStatusLine());
		ExtentListeners.extentTest.log(Status.PASS, "Status Line is verified successfully as : "+response.getStatusLine());
		
		Assert.assertEquals(response.header("Content-Type"),"application/json", "Content Type is incorrect");
		Reporter.log("Content-Type is verified successfully as : "+response.header("Content-Type"));
		ExtentListeners.extentTest.log(Status.PASS, "Content-Type is verified successfully as : "+response.header("Content-Type"));
	}
	
}
