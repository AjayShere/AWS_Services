package com.AwsServices.AwsServices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getCall")
	public String getCall() {

		String url = "https://jsonplaceholder.typicode.com/posts/1";
		String apiUrl = "https://x62rq8qqhe.execute-api.us-east-1.amazonaws.com/dev/getdata";

		Map<String, String> headers = new HashMap<>();
		headers.put("AccessKey", "AKIAYW6F2HTN5MAKMHFI");
		headers.put("SecretKey", "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");
		headers.put("AWS Region", "us-east-1");
		headers.put("Service Name", "Service Name");

		Map<String, String> headersJDSB = new HashMap<>();
		headersJDSB.put("AccessKey", "AKIAYW6F2HTN5MAKMHFI");
		headersJDSB.put("SecretKey", "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");
		headersJDSB.put("AWS Region", "us-east-1");

		// https://vi3cnq5v8d.execute-api.us-east-1.amazonaws.com/API_GW_TEST/getmockdatatest

		String apiUrlGW = "https://vi3cnq5v8d.execute-api.us-east-1.amazonaws.com/API_GW_TEST/getmockdatatest";

		ResponseEntity<placeholder> response = restTemplate.getForEntity(url, placeholder.class);
		System.out.println("op  iss " + response.getBody().toString());

		try {
			ResponseEntity<ApiGW> apiGWResponse = restTemplate.getForEntity(apiUrl, ApiGW.class, headers);

			System.out.println("op  iss " + apiGWResponse.getBody().toString());
		} catch (Exception ex) {
			System.out.println("Exception occured while callinngA API GW  " + ex);

		}
		return "Hello";
	}

}
