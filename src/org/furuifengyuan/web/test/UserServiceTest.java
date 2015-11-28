package org.furuifengyuan.web.test;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.service.UserService;
import org.furuifengyuan.web.vo.Result;
import org.junit.Test;

public class UserServiceTest  extends BaseTest{
	@Resource
    private UserService userService;
	@Test
	public void testResgisterUser(){
		UserModel userModel = new UserModel();
		userModel.setName("admin");
		userModel.setPassword("123456");
		userModel.setRole("admin");
		userModel.setSex("man");
		userModel.setAge(30);
		userModel.setCreateDate(new Date());
		userModel.setStatus(1);

	   Result<Void>result = userService.addUser(userModel);

		Assert.assertEquals(true, result.isSuccess());	
	}
	public void testModify(){
		
	}
	public void testLogin(){
		
	}
}
