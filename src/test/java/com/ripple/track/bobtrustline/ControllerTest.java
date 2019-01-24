package com.ripple.track.bobtrustline;

import org.junit.BeforeClass;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class ControllerTest {

	static HttpHeaders headers;

    static TestRestTemplate testRestTemplate;
    
    static String APPLICATION_URL = "http://localhost:8081";
    
    @BeforeClass
    public static void setupRestTemplate() {
        testRestTemplate = new TestRestTemplate(new RestTemplateBuilder().rootUri(APPLICATION_URL));
        
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }
}
