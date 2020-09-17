package files;

public class Payload {
	public static String addPlace() {
		String payload = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n" + "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}";
		return payload;
	}

	public static String updatePlace(String placeId, String address) {
		String updatePlacePayload = "{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + address
				+ "\",\r\n" + "\"key\":\"qaclick123\"\r\n" + "}";
		return updatePlacePayload;
	}

	public static String CoursePrice() {

		return "{\r\n" + "  \"dashboard\": {\r\n" + "    \"purchaseAmount\": 1162,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n" + "  },\r\n" + "  \"courses\": [\r\n" + "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n" + "      \"price\": 50,\r\n" + "      \"copies\": 6\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"Cypress\",\r\n" + "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n" + "    },\r\n" + "    {\r\n" + "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n" + "      \"copies\": 10\r\n" + "    },\r\n" + "     {\r\n"
				+ "      \"title\": \"Appium\",\r\n" + "      \"price\": 36,\r\n" + "      \"copies\": 7\r\n"
				+ "    }\r\n" + "    \r\n" + "    \r\n" + "    \r\n" + "  ]\r\n" + "}\r\n" + "";
	}
	public static String addBook() {
		String addBookBody = "{ \r\n" + 
				"\r\n" + 
				" \r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\", \r\n" + 
				"\r\n" + 
				"\"isbn\":\"bcd\", \r\n" + 
				"\r\n" + 
				"\"aisle\":\"227\", \r\n" + 
				"\r\n" + 
				"\"author\":\"John foe\" \r\n" + 
				"\r\n" + 
				"} ";
		return addBookBody;
	}
}
