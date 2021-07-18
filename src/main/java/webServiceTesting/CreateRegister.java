package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateRegister {
	
	private String email;
	private final RequestSpecification requestSpecification;
	
	public CreateRegister() {
		this.requestSpecification = RestAssured.given().baseUri("https://reqres.in/api").basePath("/register");
	}
	
	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String buildBody() {
		String body = "{\n"
				+ "  \"email\": \""+ email +"\"\n"
				+ "}";
		return body;
	}
}
