package restAssured1;

import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
	@Test
	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type", "application/json").body(Payload.addBook()).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1 = ReUsableMethods.rawToJson(response);
		String id = js1.get("ID");
		System.out.println(id);
	}

}
