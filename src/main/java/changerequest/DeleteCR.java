package changerequest;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteCR {

	@DataProvider(name = "createCRfile")
	public String[] fetchData() {
		String[] fileInfo = new String[2];
		fileInfo[0] = "./data/data0Json.json";
		fileInfo[1] = "./data/data1Json.json";
		return fileInfo;
	}

//@Test(dataProvider = "fetchData")
	@Test(dataProvider = "createCRfile")
	public void deleteCR(String fileInfo) {

		RestAssured.baseURI = "https://dev54285.service-now.com/api/now/table/change_request";

		RestAssured.authentication = RestAssured.basic("admin", "EnterPwd123!");

		// File input = new File("./data/dataJson.json");

		File input = new File(fileInfo);

		Response response = RestAssured.given().contentType(ContentType.JSON)
				.delete("3d7c800d2f5d301025e9cc96f699b608");

		response.prettyPrint();

		System.out.println(response.statusCode());

	}

}
