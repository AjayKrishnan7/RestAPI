package com.ust.sdet.api.apiframework.spec;

import com.ust.sdet.api.apiframework.config.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.ust.sdet.api.apiframework.config.Constants.baseUrl;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.lessThan;

public class SpecFactory {


    public static ResponseSpecification getRes()
    {
        return new ResponseSpecBuilder()

                .expectStatusCode(200)
                 .expectResponseTime(lessThan(800L))
                .build();
    }

    public static RequestSpecification getReq()
    {
        return new RequestSpecBuilder()

                .setBaseUri(baseUrl)
                .setBasePath("/store/inventory")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getReqId()
    {
        return new RequestSpecBuilder()

                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification deleteRes()
    {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }


    public static RequestSpecification postReq()
    {
        return new RequestSpecBuilder()

                .setBaseUri(baseUrl)
                .setBasePath("/store/order/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static RequestSpecification putReq()
    {
        return new RequestSpecBuilder()

                .setBaseUri(baseUrl)
                .setBasePath("/store/order/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification postRes()
    {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }


}
