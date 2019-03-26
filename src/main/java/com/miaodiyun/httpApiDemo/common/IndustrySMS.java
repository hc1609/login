package com.miaodiyun.httpApiDemo.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS {

	private static String accountSid = Config.ACCOUNT_SID;
	private static String templateid = "440765";

	/**
	 * 验证码通知短信
	 * 
	 * @return
	 */
	public static String execute(String mobile, String param) {
		StringBuilder sb=new StringBuilder();
		try {
			URL url = new URL(Config.BASE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(20000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/json");
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			String str = "{'sid':'"+accountSid+"',"
					+ "'token':'"+Config.AUTH_TOKEN+"',"
					+ "'appid':'"+Config.appid+"',"
					+ "'templateid':'"+templateid+"',"
					+ "'param':'"+param+"',"
					+ "'mobile':'"+mobile
					+"'}";
			System.out.println(str);
			out.write(str);
			out.flush();
			out.close();
			BufferedReader is = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String temp = null;
			while ((temp = is.readLine()) != null) {
				sb.append(temp);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 提交请求
		return sb.toString();
	}
}
