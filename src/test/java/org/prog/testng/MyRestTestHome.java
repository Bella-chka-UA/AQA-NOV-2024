package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.prog.selenium.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyRestTestHome {
    @Test
    public void myRestTestHome(){
//   https://randomuser.me/api/?inc=gender,name,nat&noinfo
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc","gender,name,nat");
        requestSpecification.queryParam("noinfo");
        requestSpecification.baseUri("https://randomuser.me");
        requestSpecification.basePath("/api/");

        Response response = requestSpecification.get();
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");

//        validatableResponse.body("results[0].gender",equalTo("female"));
//        System.out.println(response.jsonPath().get("results[0].name.first").toString());
//        Assert.assertEquals(response.jsonPath().get("results[0].gender").toString(),"female",
//                "User's gender mismatch! Expected male, but was male!");
        ResultsDto dto = response.as(ResultsDto.class);
        Assert.assertEquals(dto.getResults().get(0).getGender(),"female");
//        System.out.println(response.jsonPath().get("results[0].name.first").toString());
//
    }
}
