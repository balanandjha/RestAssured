package pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class SerailizeTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setLanguage("French-IN");
		addPlace.setWebsites("https://rahulshettyacademy.com");
		addPlace.setPhone_number("8553382245");
		addPlace.setName("Balanand Jha");

		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		addPlace.setTypes(types);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addPlace.setLocation(l);

		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		RequestSpecification reqs = given().spec(reqSpec).body(addPlace);
		
		Response resp = reqs.when().post("/maps/api/place/add/json").then().spec(respSpec).extract().response();
		
		String responseString = resp.asString();
		System.out.println(responseString);

//		Response res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(addPlace)
//				.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
//		String result = res.asString();
//		System.out.println(result);
	}

}
