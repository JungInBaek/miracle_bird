package com.multi.miraclebird.member;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MemberController {

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("user_id") == null) {
			return "redirect:https://api.instagram.com/oauth/authorize?client_id=888699415496342&redirect_uri=https://localhost:8443/miraclebird/auth&scope=user_profile,user_media&response_type=code";
		}

		return "member/login";
	}

	@GetMapping("/auth")
	public String auth(String code, Model model) throws IOException {
		System.out.println("code: " + code);
		model.addAttribute("code", code);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		String accessToken = "";
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("client_id", "888699415496342");
			map.add("client_secret", "f06a232c2096fb60125a948990434393");
			map.add("grant_type", "authorization_code");
			map.add("redirect_uri", "https://localhost:8443/miraclebird/auth");
			map.add("code", code);
			
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
			
			String stringUrl = "https://api.instagram.com/oauth/access_token";
			
			UriComponents uri = UriComponentsBuilder.fromHttpUrl(stringUrl).build();
			
			ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.POST, request, Map.class);
			
			result.put("statusCode", resultMap.getStatusCodeValue());
			result.put("header", resultMap.getHeaders());
			result.put("body", resultMap.getBody());
			
			ObjectMapper mapper = new ObjectMapper();
			accessToken = mapper.writeValueAsString(resultMap.getBody());
			
			System.out.println("accessToken: " + accessToken);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			System.out.println("에러발생");
			result.put("statusCode", e.getRawStatusCode());
			result.put("body", e.getStatusText());
			e.printStackTrace();
		} catch (Exception e) {
			result.put("statusCode", "999");
			result.put("body", "exception오류");
			System.out.println(e.toString());
		}
		
		System.out.println("accessToken: " + accessToken);
		model.addAttribute("accessToken", accessToken);
				
		return "member/auth";
//		return "redirect:https://graph.instagram.com/access_token?grant_type=ig_exchange_token&client_secret=f06a232c2096fb60125a948990434393&access_token={단기access토큰}";
	}
}
