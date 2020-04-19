import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Own_examples {

	@Test(enabled = false)
	public void test_get()

	{
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();

	}

	//@Test()
	public void test_post()
	{
		JSONObject request= new JSONObject();
		request.put("firstname", "Rekha");
		request.put("latname", "Suyal");
		request.put("subjectID", 1);
		baseURI="http://localhost:3000";

		given().contentType(ContentType.JSON).body(request.toJSONString())
		.when().post("/users") .then().
		statusCode(201)
		.log().all();


	}
	//@Test
	public void test_put()
	{
		JSONObject request= new JSONObject();
		
		request.put("lastname", "Devi");
		request.put("firstname", "Uma");
		request.put("SubjectID", "1");
		
		baseURI="http://localhost:3000";

		given().contentType(ContentType.JSON).body(request.toJSONString())
		.when().put("/users/4") .then().
		statusCode(200)
		.log().all();

}
	//@Test
		public void test_patch()
		{
			JSONObject request= new JSONObject();
			
			request.put("lastname", "Devi");
			request.put("firstname", "Usha");
			request.put("SubjectID", "1");
			
			baseURI="http://localhost:3000";

			given().contentType(ContentType.JSON).body(request.toJSONString())
			.when().patch("/users/5") .then().
			statusCode(200)
			.log().all();

	}
		
		@Test
				public void test_delete()
				{
					JSONObject request= new JSONObject();
					
//					request.put("lastname", "Devi");
//					request.put("firstname", "Usha");
//					request.put("SubjectID", "1");
					
					baseURI="http://localhost:3000";

					given().contentType(ContentType.JSON).body(request.toJSONString())
					.when().delete("/users/5") .then().
					statusCode(200)
					.log().all();

			}
}
