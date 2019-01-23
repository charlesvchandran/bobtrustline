package com.ripple.track.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ripple.track.service.TrustLineService;
import com.ripple.track.vo.TrustLineCredit;

@RestController
public class BobTrustLineController {

	Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TrustLineService trustLineService;

    @PostMapping("/api/payment")
    public HttpEntity<String> receiveCredit(@RequestBody TrustLineCredit trustLineCredit) {
        trustLineService.recordCredit(trustLineCredit.getCredit());
        trustLineService.trustLineDebit(trustLineCredit.getCredit());
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
		try {
				String response = new ObjectMapper().writeValueAsString(modelMap);
				return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (JsonProcessingException e) {
			logger.error("exception caught while recording the credit:: ", e);
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
    }
}

