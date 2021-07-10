package jira;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NewIssueCreation {

	@Test(dataProvider = "createJiraInput")
	public void createNewJira(String fileInfo) {
		RestAssured.baseURI = "https://dshri-workspace.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("durgasjd01@gmail.com", "emUQPWdYgNjiujUHGdsj46B3");
		File file = new File(fileInfo);
		Response response = RestAssured.given().contentType(ContentType.JSON).body(file).post();
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

	@DataProvider(name = "createJiraInput")
	public String[] fetchData() {
		String[] fileInfo = new String[2];
		fileInfo[0] = "./data/CreateNewJiraTD01.json";
		fileInfo[1] = "./data/CreateNewJiraTD02.json";
		return fileInfo;
	}

}
