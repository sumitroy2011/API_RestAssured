package stepdefs;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task.BookTask;

public class BookStepDef extends BookTask {

	private BookTask booktask;

	public BookStepDef(BookTask booktask) {
		super();
		this.booktask = booktask;
	}

	@Given("a book exists with an isbn of (.*)")
	public void a_book_exists_with_isbn(String isbn) throws Exception {
		booktask.isbnHandler(isbn);
	}

	@When("a user retrieves the book by isbn")
	public void a_user_retrieves_the_book_by_isbn() throws Exception {
		booktask.getBookDetails();
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode) throws Exception {
		booktask.getStatusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String, String> responseFields) throws Exception {
		booktask.responseEqualsTo(responseFields);
	}

	@And("response includes the following in any order")
	public void response_contains_in_any_order(Map<String, String> responseFields) throws Exception {
		booktask.responseContains(responseFields);
	}
}
