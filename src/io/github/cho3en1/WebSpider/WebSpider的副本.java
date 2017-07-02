package io.github.cho3en1.WebSpider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {
	public static void main(String[] args) throws IOException {
		String destStr = getURLContent("http://www.sina.com.cn/", "utf-8");
		//System.out.println(destStr);
		
		Pattern p = Pattern.compile("href=\"(.+?)\"");
		Matcher m = p.matcher(destStr);
		while(m.find()) {
			//System.out.println(m.group());
			System.out.println(m.group(1));
		}
	}
	
	public static String getURLContent(String urlStr, String charset) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset))); 
			String temp = "";
			while((temp=reader.readLine()) != null) {
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
