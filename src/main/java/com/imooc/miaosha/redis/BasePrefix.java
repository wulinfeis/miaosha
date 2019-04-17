package com.imooc.miaosha.redis;
/**
 * 
 * @author: wulinfei
 * @date:2019年3月28日 下午12:17:50
 * @Description: reids 键前缀处理类
 */
public abstract class BasePrefix implements KeyPrefix{

	private int expireSeconds;
	private String prefix;
	
	public BasePrefix(String prefix) {//0代表永不过期
		this(0, prefix);
	}
	
	public BasePrefix(int expireSeconds,String prefix){
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}
	
	@Override
	public int expireSeconds() {//默认0永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		
		return className + ":"+prefix;
	}

}
