package incident;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncident {

	public static void main(String[] args) {

//		S1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev54285.service-now.com/api/now/table/incident";

//		S2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "EnterPwd123!");
		
//		S3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.get();
		
//		S4: print response body
		response.prettyPrint();
		
//		S5: print status code
		System.out.println(response.statusCode());
	}

}
