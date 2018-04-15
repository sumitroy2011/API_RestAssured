package task;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BookTask {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

	public void isbnHandler(String isbn) throws Exception {

		request = given().param("q", "isbn:" + isbn);
	}

	public void getBookDetails() throws Exception {

		response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
	}

	public void getStatusCode(int statusCode) throws Exception {
		json = response.then().statusCode(statusCode);

	}

	public void responseEqualsTo(Map<String, String> responseFields) throws Exception {
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}

	public void responseContains(Map<String, String> responseFields) throws Exception {
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}
}
