package org.furuifengyuan.web.service;

import org.furuifengyuan.web.model.UserModel;
import org.furuifengyuan.web.vo.Result;

public interface UserService {
  
	public Result<Void> addUser(UserModel userModel);
	
	public Result<Void> modifyUser(UserModel userModel);
	
	public Result<Boolean> isLogin(UserModel userModel);
}
