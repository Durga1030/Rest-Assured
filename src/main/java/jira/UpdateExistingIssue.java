package jira;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateExistingIssue {

	@Test(dataProvider = "updateJiraInput")
	public void updateExistingJira(String fileInfo) {
		RestAssured.baseURI = "https://dshri-workspace.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("durgasjd01@gmail.com", "emUQPWdYgNjiujUHGdsj46B3");
		File file = new File(fileInfo);
		Response response = RestAssured.given().contentType(ContentType.JSON).pathParam("key", "REST1-6").body(file)
				.put("{key}");
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

	@DataProvider(name = "updateJiraInput")
	public String[] fetchData() {
		String[] fileInfo = new String[1];
		fileInfo[0] = "./data/UpdateJira.json";
		return fileInfo;
	}

}
