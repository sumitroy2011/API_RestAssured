package stepdefs;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task.FBTask;

public class FBStepDef extends FBTask {

	private FBTask fbtask;

	public FBStepDef(FBTask fbtask) {
		super();
		this.fbtask = fbtask;
	}

	@Given("user already has a facebook account")
	public void user_already_has_a_facebook_account() throws Exception {
		fbtask.fbTokenHandler();
	}

	@When("user retrives information from the facebook API")
	public void user_retrives_information_from_the_facebook_API() throws Exception {
		fbtask.getUserDetails();
	}

	@Then("the API response code is (\\d+)")
	public void verify_API_response_code(int statusCode) throws Exception {
		fbtask.getStatusCode(statusCode);
	}

	@And("response includes the following data$")
	public void response_includes_the_following_data(Map<String, String> responseFields) throws Exception {
		fbtask.responseEquals(responseFields);
	}

	@And("total time taken by the API is (\\d+) milliseconds$")
	public void total_time_taken(int seconds) throws Exception {
		fbtask.checkAPITime(seconds);
	}
}
