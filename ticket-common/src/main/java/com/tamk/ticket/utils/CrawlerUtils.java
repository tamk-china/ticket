package com.tamk.ticket.utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class CrawlerUtils {
	public static Map<String, Object> queryJson(String baseUrl, Map<String, Object> params) throws ClientProtocolException, IOException {
		if (StringUtils.isEmpty(baseUrl) || null == params) {
			throw new IllegalArgumentException();
		}

		StringBuilder sb = new StringBuilder(256);
		sb.append(baseUrl);
		if (!baseUrl.contains("?")) {
			sb.append("?");
		}
		for (Entry<String, Object> entry : params.entrySet()) {
			sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
		}

		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(sb.toString());
		HttpResponse resp = client.execute(httpGet);
		int statusCode = resp.getStatusLine().getStatusCode();
		if (HttpStatus.SC_OK != statusCode) {
			return null;
		}

		String respBody = EntityUtils.toString(resp.getEntity());
		return JSON.parseObject(respBody);
	}

	public static void main(String[] args) throws ClientProtocolException, IOException{
		String baseUrl = "http://train.qunar.com/dict/open/seatDetail.do?user=neibu&source=www&needTimeDetail=true";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dptStation", URLEncoder.encode("北京南"));
		params.put("arrStation", URLEncoder.encode("上海虹桥"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		params.put("date", sdf.format(new Date()));
		params.put("trainNo", "G101");
			
		Map<String, Object> ret = queryJson(baseUrl, params);
	}
}
