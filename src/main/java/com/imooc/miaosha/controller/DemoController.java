package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	UserService userService;
	
	@Autowired
	RedisService redisService;
	
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello World!";
	}
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello(){
		return Result.success("hello imooc");
	}
	
	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError(){
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	
	@RequestMapping("/thymeleaf")
    public String  thymeleaf(Model model) {
 		model.addAttribute("name", "Joshua");
 		return "hello";
    }
	@RequestMapping("/db/get")
	@ResponseBody
    public Result<User>  dbGet() {
 		User user = userService.getById(1);
 		return Result.success(user);
    }
	
	@RequestMapping("/db/tx")
	@ResponseBody
    public Result<Boolean>  dbTx() {
 		 userService.tx(); 
 		return Result.success(true);
    }
/*	@RequestMapping("/redis/get")
	@ResponseBody
    public Result<Long>  redisGet() {
		System.out.println("进入这个");
		Long v1 = redisService.get("key1", Long.class);
 		return Result.success(v1);
    }
	@RequestMapping("/redis/set")
	@ResponseBody
    public Result<String>  redisSet() {
		System.out.println("进入这个");
		boolean ret = redisService.set("key2", "hello,imooc");
		String str = redisService.get("key2", String.class);
 		return Result.success(str);
    }*/
	
	@RequestMapping("/redis/get")
	@ResponseBody
    public Result<User>  redisGetByFunction() {
		System.out.println("进入这个");
		User user = redisService.get(UserKey.getById, ""+1,User.class);
 		return Result.success(user);
    }
	@RequestMapping("/redis/set")
	@ResponseBody
    public Result<Boolean>  redisSetByFunction() {
		System.out.println("进入这个");
		User user = new User();
		user.setId(1);
		user.setName("11111");
		redisService.set(UserKey.getById, ""+1,user);
 		return Result.success(true);
    }
}
