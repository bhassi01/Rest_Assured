import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QA_1 {

	@Test
	public void get_JSON_response() {
		// design baseuri

		baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// adding path parameter and creating request and getting response
		RequestSpecification request = given().contentType(ContentType.JSON);

		Response response = given().contentType(ContentType.JSON).when().get("/Delhi").thenReturn();


		// Printing all the details from resposne

		System.out.println(response.getBody());
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody());
		Assert.assertEquals(response.getStatusCode(), 200);
		Headers allheader = response.getHeaders();
		for (Header h : allheader) {

			System.out.println(h);}
		
		JsonPath path_evaluator = response.jsonPath();
		String city = path_evaluator.get("City");
		Assert.assertEquals(city ,"delhi");

	}

}
