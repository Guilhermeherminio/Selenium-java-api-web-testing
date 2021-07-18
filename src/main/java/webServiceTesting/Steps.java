package webServiceTesting;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class Steps {

	CreateUser createUser;
	CreateRegister createRegister;
	String name, job;
	Response response;

	@Given("^I use (.*) creation service$")
	public void useUserCreationWebService(String type) {
		if (type.equals("user")){
			createUser = new CreateUser();
		} else {
			createRegister = new CreateRegister();
		}
	}

	@When("^I set name (.*)$")
	public void setName(String name) {
		createUser.setName(name);
	}
	
	@When("^I set e-mail (.*)$")
	public void setEmail(String email) {
		createRegister.setEmail(email);
	}
	
	@When("^I set job (.*)$")
	public void setJob(String job) {
		createUser.setJob(job);
	}
	
	@When("I create a register")
	public void i_create_a_user() {
		Response response = createRegister.getRequestSpecification()
				.given()
					.body(createRegister.buildBody())
				.when()
					.post()
				.then()
					.extract().response();
		this.response = response;
	}
	
	@When("^I create the user$")
	public void buildBody() {
		Response response = createUser.getRequestSpecification()
				.given()
					.body(createUser.buildBody())
				.when()
					.post()
				.then()
					.extract().response();
		this.response = response;
	}
	
	@When("^I delete the user$")
	public void deleteUser() {
		Response response = createUser.getRequestSpecification()
				.given()
					.delete("2")
				.then()
					.extract().response();
		this.response = response;
	}

	@Then("I validate the register was created without success")
	public void i_validate_the_register_was_created_without_success() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(400, statusCode);
	}

	@Then("^I validate the user and job was created with success$")
	public void validateUserCreated() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
	}
	
	@Then("^I validate the user and job was deleted with success$")
	public void validateUserDeleted() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(204, statusCode);
	}
}
