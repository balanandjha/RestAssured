package restAssured1;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js1 = new JsonPath(Payload.CoursePrice());
		//1. Print no. of course returned by API
		int count = js1.getInt("courses.size()");
		System.out.println(count);
		
		//2. print purchase amount
		double purchaseAmount = js1.getDouble("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//3. Print title of first course
		String title = js1.getString("courses[0].title");
		System.out.println(title);
		
		//4. Print all course title and their price
		System.out.println("4. Print all course title and their price");
		for (int i = 0; i <count; i++) {
			String titleCourse = js1.getString("courses["+i+"].title");
			String price = js1.getString("courses["+i+"].price");
			System.out.println(titleCourse+" "+price);
			
		}
		//5. Print number of copies sold by RPA
		int noOfCopiesSoldOfRpa = js1.getInt("courses[2].copies");
		System.out.println("No. of copies sold of RPA "+noOfCopiesSoldOfRpa);
		
		double sum =0;
		for (int i = 0; i <count; i++) {
			
			String priceEachCourse = js1.getString("courses["+i+"].price");
			int priceEachCourseInt = Integer.parseInt(priceEachCourse);
			int noOfCopiesSold = js1.getInt("courses["+i+"].copies");
			int priceCourse = priceEachCourseInt*noOfCopiesSold;
			sum += priceCourse;
			
		}
		System.out.println(sum);
		org.testng.Assert.assertEquals(sum, purchaseAmount);
		if (sum==purchaseAmount) {
			System.out.println("Price verified");
		}

	}

}
