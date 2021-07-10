package changerequest;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllChangeRequest {

	public static void main(String[] args) {

//		S1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev54285.service-now.com/api/now/table/change_request";

//		S2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "EnterPwd123!");

//		S3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().queryParam("sysparm_fields", "sys_id,type,number")
				.accept(ContentType.XML).get();

//		S4: print response body
		response.prettyPrint();

//		S5: print status code
		System.out.println(response.statusCode());

//		Response Body Parse
		XmlPath xmlPath = response.xmlPath();

// 		Get Customized values
		List<String> responseList = xmlPath.getList("response.result.number");

		/*
		 * System.out.println(responseList.size());
		 * System.out.println(responseList.get(responseList.size()-1));
		 * 
		 * for (String result : responseList) { System.out.println(result); }
		 */

	}

}
