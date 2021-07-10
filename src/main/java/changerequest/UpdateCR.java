package changerequest;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateCR {

	@DataProvider(name = "createCRfile")
	public String[] fetchData() {
		String[] fileInfo = new String[1];
		fileInfo[0] = "./data/data0Json.json";
		// fileInfo[1] = "./data/data1Json.json";
		return fileInfo;
	}

//@Test(dataProvider = "fetchData")
	@Test(dataProvider = "createCRfile")
	public void updateCRUsingFile(String fileInfo) {

		RestAssured.baseURI = "https://dev54285.service-now.com/api/now/table/change_request";

		RestAssured.authentication = RestAssured.basic("admin", "EnterPwd123!");

		// File input = new File("./data/dataJson.json");

		File input = new File(fileInfo);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(input)
				.pathParam("sysId", "3d7c800d2f5d301025e9cc96f699b608").patch("{sysId}");

		response.prettyPrint();

		System.out.println(response.statusCode());

	}

}

//Whether is it possible to pass multiple values in pathParam condition
