package com.imooc.miaosha.exception;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
/**
 * 
 * @version:1.0
 * @author: wulinfei
 * @date:2019年3月30日 上午11:00:51
 * @name:异常拦截
 * @Description: 拦截错误的异常，然后将异常提示语替换成业务提示
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	/**
	 * 异常拦截方法
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
	
		if(e instanceof GlobalException){//异常类型是业务异常
			GlobalException ex = (GlobalException) e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) {//当异常类型是BindException，则返回配置的提示错误信息
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
