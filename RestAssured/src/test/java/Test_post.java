import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_post {

	//@Test

	public void test_1_post()
	{

		Map<String,Object>map= new HashMap();
		map.put("name", "Raghav");
		map.put("job", "Teacher");

		System.out.println(map);

		JSONObject request= new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
	}

	@Test(priority=1)
	public void Test_post()

	{
		JSONObject request = new JSONObject();
	
		request.put("name", "Bhaskar");
		 request.put("job","Student");
		 System.out.println( request);
		 
		 given(). body(request.toJSONString())
		 .when().post("https://reqres.in/api/users")
		 .then().statusCode(201).log().all();
		

	}
@Test(priority=2)
public void test_put()
{
	JSONObject request = new JSONObject();

	request.put("name", "Bhaskar");
	 request.put("job","Tester");
	 System.out.println( request);
	 
	 given(). body(request.toJSONString())
	 .when().put("https://reqres.in/api/users/2")
	 .then().statusCode(200).log().all();
	
}
}

