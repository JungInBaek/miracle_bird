package com.multi.miraclebird.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.multi.miraclebird.user.UserVO;


@Service
@PropertySource("classpath:/properties/instagram.properties")
public class InstagramApiService {
	
	@Value("${instagram.client.id}")
	private String clientId;
	
	@Value("${instagram.client.secret}")
	private String clientSecret;
	
	@Value("${instagram.redirect.uri}")
	private String redirectUri;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getCode() {
		return "redirect:https://api.instagram.com/oauth/authorize?client_id=" + clientId +
				"&redirect_uri=" + redirectUri +
				"&scope=user_profile,user_media&response_type=code";
	}
	
	public ResponseEntity<Map> getShortTokenAndUserId(String code) {
		// 단기 엑세스 토큰, user_id
		HashMap<String, Object> shortResult = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("client_id", clientId);
		requestBody.add("client_secret", clientSecret);
		requestBody.add("grant_type", "authorization_code");
		requestBody.add("redirect_uri", redirectUri);
		requestBody.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		
		String url = "https://api.instagram.com/oauth/access_token";
		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
		
		ResponseEntity<Map> result = restTemplate.exchange(uri.toString(), HttpMethod.POST, request, Map.class);
		
		return result;
	}
	
	public ResponseEntity<Map> getLongTokenAndExpires(String shortToken) {
		// 장기 엑세스 토큰, expires_in
		String long_url = "https://graph.instagram.com/access_token";
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(long_url)
				.queryParam("grant_type", "ig_exchange_token")
				.queryParam("client_secret", clientSecret)
				.queryParam("access_token", shortToken)
				.build();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		
		ResponseEntity<Map> result = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, request, Map.class);
		
		return result;
	}
	
	public ResponseEntity<Map> getUserProfile(UserVO userVO) {
		// 사용자 프로필
		String profileUrl = "https://graph.instagram.com/me";
		UriComponents profileUrlComp = UriComponentsBuilder.fromHttpUrl(profileUrl)
				.queryParam("fields", new String[]{"id", "username"})
				.queryParam("access_token", userVO.getAccessToken())
				.build();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
					
		ResponseEntity<Map> result = restTemplate.exchange(profileUrlComp.toString(), HttpMethod.GET, request, Map.class);
		
		return result;
	}	

	public ResponseEntity<Map> getUserMedia(UserVO userVO) {
		// 사용자가 보유한 미디어
		String mediaUrl = "https://graph.instagram.com/" + userVO.getUserId() + "/media?fields=id,media_type,media_url,username,caption,timestamp";
		UriComponents mediaUrlComp = UriComponentsBuilder.fromHttpUrl(mediaUrl)
//				.queryParam("fields", new String[]{"id", "media_type", "media_url", "username", "caption", "timestamp"})
				.queryParam("access_token", userVO.getAccessToken())
				.build();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
					
		ResponseEntity<Map> result = restTemplate.exchange(mediaUrlComp.toString(), HttpMethod.GET, request, Map.class);
		
		return result;
	}
}
