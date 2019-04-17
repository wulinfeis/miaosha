package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 
 * @version:1.0
 * @author: wulinfei
 * @date:2019年3月28日 下午12:58:14
 * @name:MD5Util 加密处理
 * @Description: 客户端和服务端加密，
 */
public class MD5Util {
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
	private static final String salt = "1a2b3c4d";
	
	/**
	 * 表单密码提交，使用常量值作为加密
	 * @param inputPass
	 * @return
	 */
	public static String inputPassToFormPass(String inputPass) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
		//System.out.println(str);
		return md5(str);
	}
	/**
	 * 服务端密码处理，salt使用随机数作为加密
	 * @param formPass
	 * @param salt
	 * @return
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}
	
	/**
	 * 数据库密码处理 两次MD5+随机数加密
	 * @param inputPass
	 * @param saltDB
	 * @return
	 */
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);//form密码
		String dbPass = formPassToDBPass(formPass, saltDB);//DB密码
		return dbPass;
	}
	
	
	
	public static void main(String[] args) {
		/*System.out.println(inputPassToFormPass("123456"));//d3b1294a61a07da9b49b6e22b2cbd7f9
		System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));*/
		
		System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
		
	}
	
}
