package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.prog.selenium.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

// TODO: write simple test that will:
// TODO: - include location to query params
// TODO: - assert location.city != null
// TODO: - print timezone.description
public class RestHomework {
    @Test
    public void myRestTestHome() {
//   https://randomuser.me/api/?inc=gender,name,nat&noinfo
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.baseUri("https://randomuser.me");
        requestSpecification.basePath("/api/");

        Response response = requestSpecification.get();
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");

        ResultsDto dto = response.as(ResultsDto.class);
        Assert.assertNotNull(dto.getResults().get(0).getLocation().getCity(),
                "City in location should not be null");
        System.out.println(response.jsonPath().get("results[0].location.timezone.description").toString());

    }
}
