package task;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class FBTask {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String FACEBOOK_GRAPH_API = "https://graph.facebook.com/me";

	public void fbTokenHandler() throws Exception {

		request = given().param("access_token",
				"EAACEdEose0cBADSZBQTzyUWnk34hnUmdRRN95vsyGRAnkhmSlhj5OKmMaZAZCGYLs7NYri0l8yBeLB7nZCZCDLKbFALMTqXF0kU3qTHY5d4TKvZAij5bYuwAZBdtJSlMfrZAkNdogRYoL6nTwctJuN59BTUIKnWZCtv0XXjxE0lDYlj61CFRXfSzVYftas3ep59WXr2OowdlzcAZDZD");
	}

	public void getUserDetails() throws Exception {
		response = request.when().get(FACEBOOK_GRAPH_API);
	}

	public void getStatusCode(int statusCode) throws Exception {
		json = response.then().statusCode(statusCode);
	}

	public void responseEquals(Map<String, String> responseFields) throws Exception {
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), equalTo(field.getValue()));
			} else {
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}

	public void checkAPITime(int seconds) throws Exception {
		assert response.getTime() <= seconds : "API took " + response.getTime()
				+ " milliseconds that is more time than expected";
	}
}
