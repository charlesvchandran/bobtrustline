package com.ripple.track.bobtrustline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ripple.track.vo.TrustLineCredit;

@RunWith(SpringRunner.class)
public class BobTrustlineControllerTest extends ControllerTest {
	
	@Test
	public void creditBobTrustLine() throws JsonParseException, JsonMappingException, IOException {
		TrustLineCredit trustLineCredit = new TrustLineCredit();
		trustLineCredit.setCredit(10);
		
		HttpEntity<TrustLineCredit> request = new HttpEntity<>(trustLineCredit, headers);
	    ResponseEntity<String> accountResponseEntity = testRestTemplate
	    									.postForEntity("/bobtrustline/api/payment", request, String.class);
	    
	    assertEquals(HttpStatus.OK, accountResponseEntity.getStatusCode());
	    assertNotNull(accountResponseEntity.getBody());
	    String response = accountResponseEntity.getBody();
	   
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> map = new HashMap<String, Object>();
		map = mapper.readValue(response, new TypeReference<Map<String, Object>>(){});
		
		assertTrue(map.containsKey("success"));
		assertEquals(true, map.get("success"));
		
		assertTrue(map.containsKey("debt"));
		assertEquals(10.0, map.get("debt"));
	}
	 
}
