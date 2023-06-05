package com.nxtgenai.auth;

import static io.restassured.RestAssured.given;

import com.nxtgenai.setup.BaseTest;

import io.restassured.response.Response;

public class AuthAPI extends BaseTest {

	public static Response authenticateTheAPI() {		
		
		
		Response response = given()
								.when()
									.auth().basic("postman", "password")
									.get(config.getProperty("getAuthURL"));
		
		return response;	
	}	
}
