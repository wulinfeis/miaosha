package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidatorUtil {
	
	//手机号正则
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String mobile){
		if(StringUtils.isEmpty(mobile)){
			return false;
		}
		Matcher m = mobile_pattern.matcher(mobile);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isMobile(""));
		System.out.println(isMobile("1831706546"));
	}
}
