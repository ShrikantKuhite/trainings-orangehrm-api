package com.nxtgenai.jobportalapi;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import com.nxtgenai.setup.BaseTest;


public class JobPortalAPI extends BaseTest {

	public static Response displayJobIdDetails() {		

		Response response = given()
				.contentType(ContentType.JSON)
				.get(baseURI+config.getProperty("getpath"));		
		return response;	

	}	
	
	public static Response createJobIdDetails(String jsonPath) {	
		
		File jsonFile =  new File(jsonPath);
		
		Response response = 
				 given()
				.header("Content-Type", "application/json")
				.body(jsonFile)
				.post(baseURI+config.getProperty("postpath"));

		return response;	

	}	
	
	public static Response updateJobDetails(String jsonPath) {	
		
		File jsonFile =  new File(jsonPath);
		
		Response response = 
				 given()
				.header("Content-Type", "application/json")
				.body(jsonFile)
				.put(baseURI+config.getProperty("putpath"));

		return response;	

	}	
	
	public static Response updateJobDescription(int jobId,String jobTitle,String jobDesc) {			

		Response response = 
				 given()
				 .header("Content-Type", "application/json")
				.param("id", jobId).and()
				.param("jobTitle", jobTitle).and()
				.param("jobDescription", jobDesc)
				.patch(baseURI+config.getProperty("patchpath"));
		
		return response;	


	}	

	public static Response deleteJobIdDetails(int jobId) {

		Response response = given()
				.contentType(ContentType.JSON)
				.delete(baseURI+config.getProperty("deletepath")+jobId);

		return response;	
	}
}
