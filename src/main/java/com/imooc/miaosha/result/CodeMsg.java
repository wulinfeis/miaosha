package com.imooc.miaosha.result;

public class CodeMsg {
	private int code;
	private String msg;
	
	//通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0,"success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101,"参数校验异常:%s");
	
	//登录模块
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"登录密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号格式不正确");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214,"手机号不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"密码错误");
	
	
	//
	//秒杀模块 5005XX
	public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
	public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
	
	public int getCode() {
		return code;
	}
	public CodeMsg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public CodeMsg fillArgs(Object...args){
		int code = this.code;
		String message =String.format(this.msg, args);
		return new CodeMsg(code,message);
	}
	
	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
}
