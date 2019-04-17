package com.imooc.miaosha.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import com.imooc.miaosha.util.ValidatorUtil;
/**
 * 
 * @version:1.0
 * @author: wulinfei
 * @date:2019年3月30日 上午11:34:40
 * @name:指定校验手机号参数类
 * @Description: 对手机号参数进行校验
 * 
 * 继承ConstraintValidator接口 对应传的参数, 
 * 第一个参数 IsMobile 自定义注解名字  
 * 第二个参数 String 校验参数的类型
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String>{

	private  boolean required =false;
	
	/**
	 * 初始化方法
	 */
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();//获取自定义注解中required ，判断参数是否是必传参数
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required){//判断是否必传
			return ValidatorUtil.isMobile(value);//必传，则进行参数校验
		}else{
			if(StringUtils.isEmpty(value)){//非必传字段，并且字段为空，则验证通过
				return true;
			}else{//非必传字段，但是字段不是空，则进行参数校验
				return ValidatorUtil.isMobile(value);
			}
		}
	}

}
