package restAssured1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;

public class Basics1 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Add Place
		System.out.println("========ADD PLACE===========");
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);
		JsonPath path = new JsonPath(response);
		String placeid = path.getString("place_id");
		System.out.println(placeid);

		// Update place
		System.out.println("==========Update Place===========");
		String address = "70 winter walk, USA";
		String responseUpdate = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.updatePlace(placeid, address)).when()
				.put("maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).header("Server", "Apache/2.4.18 (Ubuntu)")
				.extract().response().asString();
		System.out.println(responseUpdate);
		// Get place
		System.out.println("============GET Place===========");
		String responseGET = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
				.header("Content-Type", "application/json").when().get("maps/api/place/get/json").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println(responseGET);
		JsonPath pathGET = new JsonPath(responseGET);
		String addressGET = pathGET.getString("address");
		System.out.println(addressGET);
		// Delete Place
		System.out.println("============Delete Place================");
		String responseDelete = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body("{\r\n" + "    \"place_id\" : \"" + placeid + "\"\r\n" + "} ").when()
				.delete("maps/api/place/delete/json").then().log().all().assertThat().statusCode(200)
				.body("status", equalTo("OK")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		JsonPath pathDelete = new JsonPath(responseDelete);
		String status = pathDelete.getString("status");
		System.out.println(status);

	}

}
