package com.ust.sdet.api.apiframework.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.internal.mapping.ObjectMapping;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.Map;

public class Constants {


    public static final String baseUrl = TestEnvironment.required("BASE_URL");


}
