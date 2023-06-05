package com.nxtgenai.auth;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nxtgenai.listeners.ExtentListeners;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AuthAPITest {

	@Test
	public void autheticateAPIUsingGetMethod() {
		Response response = AuthAPI.authenticateTheAPI();

		JsonPath jsonPath = response.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is incorrect");
		Reporter.log("Status Code is verified successfully as : "+response.getStatusCode());
		ExtentListeners.extentTest.log(Status.PASS, "Status Code is verified successfully as : "+response.getStatusCode());
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Status line is incorrect");
		Reporter.log("Status Line is verified successfully as : "+response.getStatusLine());
		ExtentListeners.extentTest.log(Status.PASS, "Status Line is verified successfully as : "+response.getStatusLine());
		
		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8", "Content Type is incorrect");
		Reporter.log("Content-Type is verified successfully as : "+response.header("Content-Type"));
		ExtentListeners.extentTest.log(Status.PASS, "Content-Type is verified successfully as : "+response.header("Content-Type"));
		
		Assert.assertEquals(jsonPath.get("authenticated"), true, "Response message does not matched");
		Reporter.log("Message body verified successfully as : "+jsonPath.get("authenticated"));
		ExtentListeners.extentTest.log(Status.PASS, "Message body verified successfully as : "+jsonPath.get("authenticated"));
		
	}
}
