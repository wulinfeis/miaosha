package com.imooc.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.imooc.miaosha.domain.User;

@Mapper
public interface UserDao {
	@Select("select * from USERss where id = #{id}")
	public User getById(@Param("id")int id);
	
	@Insert("insert into USERsss(id,name) values(#{id},#{name})")
	public int insert(User user);
}
