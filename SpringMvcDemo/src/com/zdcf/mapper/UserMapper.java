package com.zdcf.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;

import com.zdcf.model.Airticle;
import com.zdcf.model.User;

/**
  * @author gacl
  * 定义sql映射的接口，使用注解指明方法要执行的SQL
  */
public interface UserMapper {

    @Select("select * from t_user where ip=#{ip}")
    public User getUserByIp(String ip);
    
    @Select("select password from t_user where username=#{username}")
    public String getPwdByName(String username);
    
    @Select("select id from t_user where username=#{username}")
    public Integer getUidByName(String username);
    
    @Select("select id as id,username as username,password as password from t_user where username=#{username}")
    public User getUserByName(String username);
    
    @Select("select username from t_user where id=#{id}")
    public String getNameById(int id);
	
    @Insert("insert into t_user(username,password,ip,register_time) values (#{ip},#{ip},#{ip},now())")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	public int addUserByIp(String ip);
    
    @Insert("insert into t_user(username,password,ip,register_time,email,avatar,auto_login_code) values (#{username},#{password},#{ip},now(),#{email},#{avatar},#{autoLoginCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	public int addUser(User user);
    
}
