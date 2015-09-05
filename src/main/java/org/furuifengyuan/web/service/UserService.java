package org.furuifengyuan.web.service;

import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.vo.Result;

public interface UserService {
  
	public Result<Boolean> addUser(UserModel userModel);
	
	public Result<Boolean> modifyUser(UserModel userModel);
	
	public Result<Boolean> isLogin(UserModel userModel);
}
