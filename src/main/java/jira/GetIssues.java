package jira;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIssues {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dshri-workspace.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("durgasjd01@gmail.com", "emUQPWdYgNjiujUHGdsj46B3");
		Response response = RestAssured.get();
		JsonPath jsonPath = response.jsonPath();
		List<String> result = jsonPath.getList("issues.key");
		for (String eachId : result) {
			System.out.println(eachId);

		}
	}

}