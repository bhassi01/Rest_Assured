import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_Get {

	@Test
	void test01() {

		Response response = get("https://reqres.in/api/users?page=2");
		int statuscode = response.getStatusCode();
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		Assert.assertEquals(statuscode, 200);

	}

@Test
void test02()
{
	
	given().get("https://reqres.in/api/users?page=2").
	then().
	statusCode(200)
	.body("data.id[0]",equalTo(7));
}
}
