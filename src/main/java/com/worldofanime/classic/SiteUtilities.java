package com.worldofanime.classic;

public class SiteUtilities {

	public static String GenerateSafeUrl(String url) {
		url = url.toLowerCase();
		url = url.replaceAll("\"","");
		url = url.replaceAll("[\\(\\):!\\,'%\\?\\.\\/]", "");
		url = url.replaceAll("&", " and ");
		url = url.replaceAll("\\s+","_");
		return url;
	}


	public static String GetStringForHTML(String content) {
		content = content.replace("\n", "<p />");
		return content;
	}

	public static String GetShortenedStringForHTML(String content) {
		if (content.length() > 250) {
			content = content.substring(0, 250);
			content += "...";			
		}

		return content;
	}

}