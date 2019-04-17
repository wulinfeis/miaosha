package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;

/**
 * 
 * @version:1.0
 * @author: wulinfei
 * @date:2019年4月1日 下午9:01:34
 * @name:业务异常类
 * @Description: 直接通过业务异常类，进行抛出异常
 */
public class GlobalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CodeMsg cm;
	public GlobalException(CodeMsg cm){
		super(cm.toString());
		this.cm = cm;
	}
	public CodeMsg getCm() {
		return cm;
	}
	public void setCm(CodeMsg cm) {
		this.cm = cm;
	}
	
}
