package com.imooc.miaosha.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * @version:1.0
 * @author: wulinfei
 * @date:2019年3月30日 上午11:31:33
 * @name:手机号格式校验
 * @Description: JSR303 自定义手机号格式校验
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})//指定校验参数类
public @interface IsMobile {
	
	boolean required() default true;//ture 默认必传，  false 默认不必传
	
	String message() default "手机号格式错误 ";//对应的错误信息

	Class<?>[] groups() default { }; 

	Class<? extends Payload>[] payload() default { };
}
