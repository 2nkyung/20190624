package com.osf.sp.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osf.sp.dao.NaverTranslationDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NaverTransController {

	@Resource
	private NaverTranslationDAO ntdao;

	@GetMapping("/translations")
	public @ResponseBody List<Map<String, Object>> getTranslations() {
		return ntdao.selectTranslationHisList();
	}

	@GetMapping("/translation/{target}/{source}/{text}")
	public @ResponseBody Object doTranslation(@PathVariable("target") String target,
			@PathVariable("source") String source, @PathVariable("text") String text) {
		log.info("target=>{},source=>{},text=>{}", new String[] { target, source, text });
		return translationTest(target, source, text);
	}

	private Object translationTest(String target, String source, String text) {
		String clientId = "RKMtE3jrPVvv5gSRHZiv";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "c8Y2Z65ugb";// 애플리케이션 클라이언트 시크릿값";
		try {
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// post request
			String postParams = "source=" + source + "&target" + target + "&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			log.error("error=>{}",e);
		}
		return null;
	}
}
